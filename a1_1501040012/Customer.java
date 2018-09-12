package a1_1501040012;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @Overview Customer is the person who are of interest to the flower shop.
 * @attributes 
 * 	id 			Integer 
 * 	name 		String 
 * 	phoneNumber String 
 * 	address 	String
 * @Object 
 * 	A typical Customer is <pre>c = <i, n, p, a></pre>, where
 *    <pre>id(id), name(n), phoneNumber(p), address(a)</pre>
 * @abstract_properties mutable(id)=false /\ optional(id)=false /\ min(id)=1 /\ max(id)=1000000 
 * 						mutable(name)=true /\ optional(name)=false /\ length(name)=50
 *                      mutable(phoneNumber)=true /\ optional(phoneNumber)=false /\ length(phoneNumber)=10 
 *                      mutable(address)=true /\ optional(address)=false /\ length(address)=100
 * @author anh.nguyenvan
 */

public class Customer implements Comparable<Customer> {

	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1, max = 10^6)
	private Integer id;
	@DomainConstraint(type = "String", optional = false, length = 50)
	private String name;
	@DomainConstraint(type = "String", optional = false, length = 10)
	private String phoneNumber;
	@DomainConstraint(type = "String", optional = false, length = 100)
	private String address;
	private final static int MIN_CID = 1;
	private final static int MAX_CID = (int)Math.pow(10, 6);
	private final static int LENGTH_NAME = 50;
	private final static int LENGTH_PHONENUMBER = 10;
	private final static int LENGTH_ADDRESS = 100;
	
	// constructor method
	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if i, n, p, a are valid
	 * 			initialize this as Customer:<i, n, p, a>
	 * 		else
	 * 			throws NotPossibleException
	 *          </pre>
	 */
	public Customer(@AttrRef("id") Integer i, @AttrRef("name") String n, @AttrRef("phoneNumber") String p,
			@AttrRef("address") String a) throws NotPossibleException {
		if (validate(i, n, p, a)) {
			id = i;
			name = n;
			phoneNumber = p;
			address = a;
		} else {
			throw new NotPossibleException("Customer<init>: invalid arguments");
		}
	}

	/**
	 * @effects return <tt>this.id</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("id")
	public Integer getId() {
		return id;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if id is valid
	 * 			return true
	 * 		else
	 * 			return false
	 *          </pre>
	 */
	protected boolean validateId(int id) {
		if (id >= MIN_CID && id < MAX_CID)
			return true;
		else
			return false;
	}

	/**
	 * @effects return <tt>this.name</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("name")
	public String getName() {
		return name;
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
	@AttrRef("name")
	public void setName(String name) throws NotPossibleException{
		if (validateName(name))
			this.name = name;
		else
			throw new NotPossibleException("Customer.setName: invalid name " + name);
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
	private boolean validateName(String name) {
		if (name == null || name.length() > LENGTH_NAME)
			return false;
		else
			return true;
	}

	/**
	 * @effects return <tt>this.phoneNumber</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if name is valid
	 * 			set this.phoneNumber = phoneNumber
	 * 		else
	 * 			throws NotPossibleException
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("phoneNumber")
	public void setPhoneNumber(String phoneNumber) throws NotPossibleException{
		if (validatePhoneNumber(phoneNumber))
			this.phoneNumber = phoneNumber;
		else
			throw new NotPossibleException("Customer.setPhoneNumber: invalid phoneNumber" + phoneNumber);
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if phoneNumber is valid
	 * 			return true
	 * 		else
	 * 			return false
	 *          </pre>
	 */
	private boolean validatePhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() > LENGTH_PHONENUMBER)
			return false;
		else
			return true;
	}

	/**
	 * @effects return <tt>this.address</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("address")
	public String getAddress() {
		return address;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if name is valid
	 * 			set this.address = address
	 * 		else
	 * 			throws NotPossibleException
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("address")
	public void setAddress(String address) {
		if (validateAddress(address))
			this.address = address;
		else
			throw new NotPossibleException("Customer.setAddress: invalid address" + address);
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if address is valid
	 * 			return true
	 * 		else
	 * 			return false
	 *          </pre>
	 */
	private boolean validateAddress(String address) {
		if (address == null || address.length() > LENGTH_ADDRESS)
			return false;
		else
			return true;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if <i, n, p, a> is valid tuple
	 * 			return true
	 * 		else
	 * 			return false
	 *          </pre>
	 */
	private boolean validate(Integer i, String n, String p, String a) {
		return validateId(i) && validateName(n) && validatePhoneNumber(p) && validateAddress(a);
	}

	@Override
	public String toString() {
		return "Customer[id = " + id + "; named = " + name + "; phoneNumber = " + phoneNumber
				+ "; address = " + address + "]";
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if this satisfies rep invariant
	 * 			return true
	 * 		else
	 * 			return false
	 *          </pre>
	 */
	public boolean repOK() {
		return validate(id, name, phoneNumber, address);
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if the name of 2 Customer is not the same
	 * 					return value != 0
	 * 				  else
	 * 					return value == 0
	 *          </pre>
	 */
	@Override
	public int compareTo(Customer other) {
		int value = (this.name).compareTo(other.name);
		if (value == 0)
			System.out.println("Two customer have the same name or maybe they are one person! Because the return value is ");
		else
			System.out.println("They have different name!!! Because the return value is ");
		return value;
	}

}
