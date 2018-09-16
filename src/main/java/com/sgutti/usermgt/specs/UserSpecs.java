/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.sgutti.usermgt.entities.User;

/**
 * @author Shanmu
 * @date Jul 18, 2014 11:56:32 AM
 */
public class UserSpecs {
    // --------------------------------------------------------------- Constants
    private static final String WILDCARD = "%";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>UserSpecs</code>
     */
    private UserSpecs() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    /**
     * @param tenantID
     * @param firstName
     * @param lastName
     * @param exactMatch
     * @return
     */
    public static Specification<User> getWhere(final long tenantID,
                                               final String firstName,
                                               final String lastName,
                                               final boolean exactMatch) {
        return new Specification<User>() {
            private static final long serialVersionUID = 4826731951694930259L;
            /**
             * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root,
             *      javax.persistence.criteria.CriteriaQuery,
             *      javax.persistence.criteria.CriteriaBuilder)
             */
            @Override
            public Predicate toPredicate(final Root<User> root,
                                         final CriteriaQuery<?> query,
                                         final CriteriaBuilder criteriaBuilder) {
                Predicate resultPredicate = criteriaBuilder.conjunction();
                resultPredicate.getExpressions().add(
                        criteriaBuilder.equal(root.get("tenantID"), tenantID));
                String firstNameStr = null;
                String lastNameStr = null;
                // This list will contain all Predicates (where clauses)
                if (exactMatch) {
                    firstNameStr = firstName;
                    lastNameStr = lastName;
                } else {
                    if (StringUtils.isNotBlank(firstName)) {
                        firstNameStr = WILDCARD + firstName + WILDCARD;
                    } else {
                        firstNameStr = WILDCARD + firstName;
                    }
                    if (StringUtils.isNotBlank(lastName)) {
                        lastNameStr = WILDCARD + lastName + WILDCARD;
                    } else {
                        lastNameStr = WILDCARD + lastName;
                    }
                }
                if (exactMatch) {
                    if (StringUtils.isNotBlank(firstNameStr)) {
                        resultPredicate.getExpressions().add(criteriaBuilder
                                .equal(root.get("firstName"), firstNameStr));
                    }
                    if (StringUtils.isNotBlank(lastNameStr)) {
                        resultPredicate.getExpressions().add(criteriaBuilder
                                .equal(root.get("lastName"), lastNameStr));
                    }
                } else {
                    Predicate fn = null;
                    Predicate ln = null;
                    if (StringUtils.isNotBlank(firstNameStr)) {
                        fn = criteriaBuilder.like(
                                criteriaBuilder
                                        .lower(root.<String> get("firstName")),
                                firstNameStr);
                    }
                    if (StringUtils.isNotBlank(lastNameStr)) {
                        ln = criteriaBuilder.like(
                                criteriaBuilder
                                        .lower(root.<String> get("lastName")),
                                lastNameStr);
                    }
                    if (fn != null && ln != null) {
                        resultPredicate = criteriaBuilder.and(fn, ln);
                    } else if (fn != null && ln == null) {
                        resultPredicate = criteriaBuilder.and(fn);
                    } else if (fn == null && ln != null) {
                        resultPredicate = criteriaBuilder.and(ln);
                    }
                    resultPredicate.getExpressions().add(criteriaBuilder
                            .equal(root.get("tenantID"), tenantID));
                }
                return resultPredicate;
            }
        };
    }
    // ----------------------------------------------------------- Inner Classes
}
