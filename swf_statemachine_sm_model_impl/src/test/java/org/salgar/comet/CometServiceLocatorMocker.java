package org.salgar.comet;

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Broadcaster;
import org.easymock.EasyMock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;

public class CometServiceLocatorMocker {
	public static Broadcaster mock() {
		Broadcaster broadcasterMock = EasyMock
				.createMock(Broadcaster.class);
		expect(broadcasterMock.broadcast(anyObject(), anyObject(AtmosphereResource.class))).andReturn(new Future<Object>() {

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
			}
		}).times(2);

		return broadcasterMock;
	}
}
