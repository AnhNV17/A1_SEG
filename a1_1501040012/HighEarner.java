package a1_1501040012;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @Overview HighEarner is a person who are wealthy customer whose income are above a given threshold.
 * @attribute
 * 	income	Float
 * @abstract_properties
 * 	P_Customer /\
 * 	min(id) = 10000000 /\
 * 	min(income) = 10000000
 * @author anh.nguyenvan
 */
public class HighEarner extends Customer {

	private static final int MIN_ID = (int)Math.pow(10, 7);
	private static final int MIN_INCOME = (int)Math.pow(10, 7);
	@DomainConstraint(type = "Float", optional = false, min = 10^7)
	private Float income;

	// constructor method
	/**
	 * @effects
	 * 
	 *          <pre>
	 *			if i, n, p, a, in are valid
	 *				initialize this as HighEarner:<i, n, p, a, in>
	 *			else
	 *				throws NotPossibleException
	 *          </pre>
	 */
	public HighEarner(@AttrRef("id") Integer i, @AttrRef("name") String n, @AttrRef("phoneNumber") String p,
			@AttrRef("address") String a, @AttrRef("income") Float in) throws NotPossibleException{
		super(i, n, p, a);
		if (validateIncome(in))
			income = in;
		else
			throw new NotPossibleException("HighEarner.inint: invalid income");
	}

	/**
	 * @effects return <tt>this.income</tt>
	 */
	@DOpt(type = OptType.Observer)
	public Float getIncome() {
		return income;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if name is valid
	 * 			set this.name = name
	 * 		else
	 * 			throws NotPossibleException
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	public void setIncome(Float income) {
		if (validateIncome(income))
			this.income = income;
		else
			throw new NotPossibleException("HighEarner.setIncome: invalid income " + income);
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if name is valid
	 * 			return true
	 * 		else
	 * 			return false
	 *          </pre>
	 */
	private boolean validateIncome(Float income) {
		if (income > MIN_INCOME)
			return true;
		else
			return false;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 *            if in is valid 
	 *              return true 
	 *            else 
	 *              return false
	 *          </pre>
	 */
	@Override
	@DomainConstraint(type = "Integer", optional = false, min = 10^7)
	protected boolean validateId(int in) {
		if (in < MIN_ID)
			return false;
		else
			return true;
	}

	@Override
	public String toString() {
		return "HighEarner[id = " + getId() + "; named = " + getName() + "; phoneNumber = " + getPhoneNumber()
				+ "; address = " + getAddress() + "; income = " + getIncome() + "]";
	}

	@Override
	public boolean repOK() {
		if (super.repOK()) {
			return validateIncome(income);
		} else
			return false;
	}
	
	
}
