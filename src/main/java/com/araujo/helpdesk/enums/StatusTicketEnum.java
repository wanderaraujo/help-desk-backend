package com.araujo.helpdesk.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Contain status ticket enum
 * @author wander
 * @see Ticket
 */
public enum StatusTicketEnum {

	New,
	Assigned,
	Resolved,
	Approved,
	Disapproved,
	Closed;
	
	
	/**
	 * Method to get status from enum
	 * @param status to get name inside enum
	 * @return enum contain status ticket
	 */
	public static StatusTicketEnum getStatusTicketEnum(String status) {
		for (StatusTicketEnum statusEnum : StatusTicketEnum.values()) {
			if(StringUtils.equalsIgnoreCase(status, statusEnum.toString())){
				return statusEnum;
			}
		}
		return New;
	}
}
