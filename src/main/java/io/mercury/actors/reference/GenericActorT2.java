package io.mercury.actors.reference;

import io.mercury.actors.base.CommonActor;

public abstract class GenericActorT2<T1, T2> extends CommonActor {

	private Class<T1> type1;
	private Class<T2> type2;

	protected GenericActorT2() {
		this.type1 = eventType1();
		this.type2 = eventType2();
	}

	@Override
	public final Receive createReceive() {
		return receiveBuilder().match(type1, this::onEvent1).match(type2, this::onEvent2).matchAny(this::handleUnknown)
				.build();
	}
	
	private void handleUnknown(Object obj) {
		commonHandleUnknown(obj);
		handleUnknown0(obj);
	}

	protected abstract Class<T1> eventType1();

	protected abstract Class<T2> eventType2();

	protected abstract void onEvent1(T1 t1);

	protected abstract void onEvent2(T2 t2);
	
	protected abstract void handleUnknown0(Object t);

}
