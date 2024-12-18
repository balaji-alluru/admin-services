package io.mosip.admin.bulkdataupload.entity.id;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Kishan Rathore
 *
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcptionalHolidayId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9206683365413202093L;

	@Column(name = "regcntr_id", nullable = false, length = 10)
	private String registrationCenterId;

	@Column(name = "hol_date", nullable = false)
	private LocalDate holidayDate;

}
