package prakash.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
// ye table optional hai by default class name he table name hojayega
@Table(name="students")

public class Student {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(name = "student_name",
             nullable = false,
             length = 100
     )
    private String name;
     @Column(unique = true,
             nullable = false,
             length = 150,
             insertable = true,
             updatable = true
     )
    private String email;
    private int age;
    @Column(precision=5,scale=2)
    private BigDecimal percentage;

    private LocalDate dateOfBirth;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)

    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private StudentStatus status;
    @Lob
    private String profileDescription;
    // propity table me nahi jayega
    @Transient
    private String displayName;
    @Convert(converter=BooleanToStringConverter.class)
    private Boolean isMonitor;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
               name="houseNo",
               column=@Column(name = "current_house_no")
            ),
            @AttributeOverride(
                    name="street",
                    column=@Column(name = "current_street")
            ),
            @AttributeOverride(
                    name="city",
                    column=@Column(name = "current_city")
            ),
            @AttributeOverride(
                    name="state",
                    column=@Column(name = "current_state")
            ),
            @AttributeOverride(
                    name="pincode",
                    column=@Column(name = "current_pincode")
            )
    })
    private Address currentAddress;
    @AttributeOverrides({
            @AttributeOverride(
                    name="houseNo",
                    column=@Column(name = "parmanent_house_no")
            ),
            @AttributeOverride(
                    name="street",
                    column=@Column(name = "parmanent__street")
            ),
            @AttributeOverride(
                    name="city",
                    column=@Column(name = "parmanent_city")
            ),
            @AttributeOverride(
                    name="state",
                    column=@Column(name = "parmanent_state")
            ),
            @AttributeOverride(
                    name="pincode",
                    column=@Column(name = "parmanent_pincode")
            )
    })
    private Address permanentAddress;

  @ElementCollection
  @CollectionTable(
          name="student_skills",
          joinColumns =@JoinColumn(name = "student_id")
  )
    private Set<String> skills;
    @ElementCollection
    @CollectionTable(
            name="student_address",
            joinColumns =@JoinColumn(name = "student_id")
    )
private  Set<Address>address;
    public Student() {
    }

    public Student(String name, String email, int age, BigDecimal percentage, LocalDate dateOfBirth, LocalDateTime createdAt, StudentStatus status, String profileDescription, String displayName, Boolean isMonitor,Address currentAddress,Address permanentAddress,Set<String>skills,Set<Address>address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.percentage=percentage;
        this.dateOfBirth=dateOfBirth;
        this.createdAt = createdAt;
        this.status=status;
        this.profileDescription=profileDescription;
        this.displayName=displayName;
        this.isMonitor=isMonitor;
        this.currentAddress=currentAddress;
        this.permanentAddress=permanentAddress;
        this.skills=skills;
        this.address=address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Student setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Student setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public Boolean getIsMonitor() {
        return isMonitor;
    }

    public void setIsMonitor(Boolean monitor) {
        isMonitor = monitor;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public Student setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
        return this;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public Student setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
        return this;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public Student setStatus(StudentStatus status) {
        this.status = status;
        return this;
    }

    public Address permanentAddress() {
        return permanentAddress;
    }

    public Student setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
        return this;
    }

    public Address currentAddress() {
        return currentAddress;
    }

    public Student setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public Set<String> skills() {
        return skills;
    }

    public Student setSkills(Set<String> skills) {
        this.skills = skills;
        return this;
    }

    public Set<Address> address() {
        return address;
    }

    public Student setAddress(Set<Address> address) {
        this.address = address;
        return this;
    }
}
