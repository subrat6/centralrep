package com.don.accessor;

import java.io.IOException;

public interface IAcessor {
	String getkey();

	Object getData() throws IOException;
}
