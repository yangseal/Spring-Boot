package com.cnten.platform.util;

import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.UUIDHexGenerator;

public class UUIDUtil {

	public static String getUUID() {
		IdentifierGenerator uuid = new UUIDHexGenerator();
		return uuid.generate(null, null).toString();
	}
}
