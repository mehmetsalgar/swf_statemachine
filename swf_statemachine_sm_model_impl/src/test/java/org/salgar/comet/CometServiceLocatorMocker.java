package org.salgar.comet;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.atmosphere.cpr.Broadcaster;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.*;

public class CometServiceLocatorMocker {
	private static final Broadcaster broadcasterMock = EasyMock
			.createMock(Broadcaster.class);

	public static void mock() {
		expect(broadcasterMock.broadcast(anyObject())).andReturn(new Future<Object>(){

			public boolean cancel(boolean arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			public Object get() throws InterruptedException, ExecutionException {
				// TODO Auto-generated method stub
				return null;
			}

			public Object get(long arg0, TimeUnit arg1)
					throws InterruptedException, ExecutionException,
					TimeoutException {
				// TODO Auto-generated method stub
				return null;
			}

			public boolean isCancelled() {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean isDone() {
				// TODO Auto-generated method stub
				return false;
			}});
		CometServiceLocator.getInstance().setBroadcaster(broadcasterMock);
	}

	public static Broadcaster getMockObject() {
		return broadcasterMock;
	}
}
