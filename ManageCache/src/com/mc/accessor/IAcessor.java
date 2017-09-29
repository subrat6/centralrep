package com.mc.accessor;

import java.io.IOException;

public interface IAcessor {
	String getKey();

	Object getData() throws IOException;
}
