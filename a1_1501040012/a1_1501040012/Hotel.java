package a1_1501040012;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @Overview Hotel represents popular hostels whose services are rated above a given threshold.
 * @attribute
 * 	noStars		Float
 * @Object
 * 	A typical Hotel is <pre>hot = <i, n, a, no, p, nos></pre>where
 * 		<pre>id(i), name(n), address(a), noRooms(no), price(p), noStars(nos)</pre>
 * @abstract_properties		P_Customer /\ min(noRooms) = 15
 * 							mutable(noStars)=true /\ optional(noStars)=false /\ min(noStars)=3 /\ max(noStars)=5
 * @author anh.nguyenvan
 */
public class Hotel extends Hostel {

	private static final int MIN_NO_HOTEL = 15;
	private static final int MIN_NO_STARS = 3;
	private static final int MAX_NO_STARS = 5;
	@DomainConstraint(type = "Float", optional = false, min = 3, max = 5)
	private Float noStars;

	// constructor method
	/**
	 * @effects
	 * 
	 *          <pre>
	 *			if i, n, a, no, p, nos in are valid
	 *				initialize this as Hotel:<i, n, a, no, p, nos>
	 *			else
	 *				throws NotPossibleException
	 *          </pre>
	 */
	public Hotel(@AttrRef("id") Integer i, @AttrRef("name") String n, @AttrRef("address") String a,
			@AttrRef("noRooms") Integer no, @AttrRef("price") Float p, @AttrRef("noStars") Float nos)
			throws NotPossibleException {
		super(i, n, a, no, p);
		if (validateIncome(nos))
			noStars = nos;
		else
			throw new NotPossibleException("Hotel.init: invalid noStars");
	}

	/**
	 * @effects return <tt>this.noStars</tt>
	 */
	@DOpt(type = OptType.Observer)
	public Float getNoStars() {
		return noStars;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if noStars is valid
	 * 			set this.noStars = noStars
	 * 		else
	 * 			throws NotPossibleException
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	public void setIncome(Float noStars) {
		if (validateIncome(noStars))
			this.noStars = noStars;
		else
			throw new NotPossibleException("HighEarner.setIncome: invalid income " + noStars);
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if noStars is valid
	 * 			return true
	 * 		else
	 * 			return false
	 *          </pre>
	 */
	private boolean validateIncome(Float noStars) {
		if (noStars < MIN_NO_STARS || noStars > MAX_NO_STARS)
			return false;
		else
			return true;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 *            if noRooms is valid 
	 *              return true 
	 *            else 
	 *              return false
	 *          </pre>
	 */
	@Override
	@DomainConstraint(type = "Integer", optional = false, min = 15)
	protected boolean validateId(int no) {
		if (no < MIN_NO_HOTEL)
			return false;
		else
			return true;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + getId() + ", name=" + getName() + ", address=" + getAddress() + ", number of rooms="
				+ getNoRooms() + ", price=" + getPrice() + "; number of stars" + noStars + "]";
	}

	@Override
	public boolean repOK() {
		if (super.repOK()) {
			return validateIncome(noStars);
		} else
			return false;
	}

}
