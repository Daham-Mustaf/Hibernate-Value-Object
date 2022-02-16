
# Hibernate-Value-Object

A Value Type object has no database identity of its own and it is Embedded within the same row of its associated Entity class 
```java
public class Student {


	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(column = @Column(name = "home_street_name", length = 50), name = "street"),
			@AttributeOverride(column = @Column(name = "home_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name = "home_state_name"), name = "state"),
			@AttributeOverride(column = @Column(name = "home_pin_code"), name = "pincode") })
	private Address homAddress;

	@Embedded
	@AttributeOverrides(value = {

			@AttributeOverride(column = @Column(name = "offfice_street_name", length = 60), name = "street"),
			@AttributeOverride(column = @Column(name = "office_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name = "office_state_name"), name = "state"),
			@AttributeOverride(column = @Column(name = "office_pin_code"), name = "pincode") })
	private Address officAddress;
   ```
 within a single database table i.e. each object of Credentials is stored as a part of each Student object.
