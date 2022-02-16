package main.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_table")
@DynamicUpdate
public class Student {

	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @SequenceGenerator(name = "stuId-generator", initialValue = 1, allocationSize
	// = 1)
	private Integer studentId;

	@Column(name = "student_name", length = 100, nullable = false)
	private String studentName;

	@Column(length = 46, name = "email", unique = true)
	private String email;

	@Column(name = "date_of_joing")
	private Date doj;

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

}