package io.mosip.kernel.masterdata.validator.registereddevice;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * Annotation that validates the Purpose Column value.
 * 
 * @author Megha Tanga
 * @since 1.0
 *
 */
@Documented
@Constraint(validatedBy = PurposeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPurpose {
	String message() default "Purpose value not supported";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
