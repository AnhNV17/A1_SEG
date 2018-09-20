package a1_1501040012;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @Overview Hostel represents hostels that are of interest to the travellers.
 * @attributes 
 * 	id 			Integer 
 * 	name 		String 
 * 	address 	String
 * 	noRooms		Integer
 * 	price		Float
 * @Object 
 * 	A typical Hostel is <pre>hos = <i, n, a, no, p></pre>, where
 *    <pre>id(i), name(n), address(a), noRooms(no), price(p)</pre>
 * @abstract_properties mutable(id)=false /\ optional(id)=false /\ min(id)=1 
 * 						mutable(name)=true /\ optional(name)=false /\ length(name)=70
 *                      mutable(address)=true /\ optional(address)=false /\ length(address)=150
 *                      mutable(noRooms)=true /\ optional(noRooms)=flase /\ min(noRooms)=3 /\ max(noRooms)=14
 *                      mutable(price)=true /\ optional(price)=false /\ min(price)=1
 * @author anh.nguyenvan
 */

public class Hostel implements Comparable<Hostel> {

	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
	private Integer id;
	@DomainConstraint(type = "String", optional = false, length = 70)
	private String name;
	@DomainConstraint(type = "String", optional = false, length = 150)
	private String address;
	@DomainConstraint(type = "Integer", optional = false, min = 3, max = 14)
	private Integer noRooms;
	@DomainConstraint(type = "Float", optional = false, min = 1)
	private Float price;
	private final static int MIN_ID = 1;
	private final static int LENGTH_NAME = 70;
	private final static int LENGTH_ADDRESS = 150;
	private final static int MIN_NO_HOSTEL = 3;
	private final static int MAX_NO_HOSTEL = 14;
	private final static int MIN_PRICE = 1;

	// constructor method
	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if i, n, a, no, p are valid
	 * 			initialize this as Hostel:<i, n, a, no, p>
	 * 		else
	 * 			throws NotPossibleException
	 *          </pre>
	 */
	public Hostel(@AttrRef("id") Integer i, @AttrRef("name") String n, @AttrRef("address") String a,
			@AttrRef("noRooms") Integer no, @AttrRef("price") Float p) throws NotPossibleException {
		if (validate(i, n, a, no, p)) {
			id = i;
			name = n;
			address = a;
			noRooms = no;
			price = p;
		} else {
			throw new NotPossibleException("Hostel<init>: invalid arguments");
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
		if (id >= MIN_ID)
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
	public void setName(String name) throws NotPossibleException {
		if (validateName(name))
			this.name = name;
		else
			throw new NotPossibleException("Hostel.setName: invalid name " + name);
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
			throw new NotPossibleException("Hostel.setAddress: invalid address " + address);
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
	 * @effects return <tt>this.noRooms</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("noRooms")
	public Integer getNoRooms() {
		return noRooms;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if noRooms is valid
	 * 			set this.noRooms = noRooms
	 * 		else
	 * 			throws NotPossibleException
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("noRooms")
	public void setNoRooms(Integer noRooms) {
		if (validateNoRooms(noRooms))
			this.noRooms = noRooms;
		else
			throw new NotPossibleException("Hostel.setNoRooms: invalid noRooms "+ noRooms);
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if noRooms is valid
	 * 			return true
	 * 		else
	 * 			return false
	 *          </pre>
	 */
	private boolean validateNoRooms(Integer noRooms) {
		if (noRooms < MIN_NO_HOSTEL || noRooms > MAX_NO_HOSTEL)
			return false;
		else
			return true;
	}

	/**
	 * @effects return <tt>this.price</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("price")
	public Float getPrice() {
		return price;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if price is valid
	 * 			set this.price = price
	 * 		else
	 * 			throws NotPossibleException
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("price")
	public void setPrice(Float price) {
		if (validatePrice(price))
			this.price = price;
		else
			throw new NotPossibleException("Hostel.setPrice: invalid price " +price);
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if price is valid
	 * 			return true
	 * 		else
	 * 			return false
	 *          </pre>
	 */
	private boolean validatePrice(Float price) {
		if (price < MIN_PRICE)
			return false;
		else
			return true;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * 		if <i, n, a, no, p> is valid tuple
	 * 			return true
	 * 		else
	 * 			return false
	 *          </pre>
	 */
	private boolean validate(Integer i, String n, String a, Integer no, Float p) {
		return validateId(i) && validateName(n) && validateAddress(a) && validateNoRooms(no) && validatePrice(p);
	}

	@Override
	public String toString() {
		return "Hostel [id=" + id + ", name=" + name + ", address=" + address + ", number of rooms=" + noRooms + ", price="
				+ price + "]";
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
		return validate(id, name, address, noRooms, price);
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
	public int compareTo(Hostel other) {
		int value = (this.price).compareTo(other.price);
		if (value == 0)
			System.out.println("The same price! Because the return value is ");
		else
			System.out.println("The different price!!! Because the return value is ");
		return value;
	}

}
