package com.pg.dp.state;

public class StateSwitchDP {

}

class FanSwitch implements Switch{
	private SwitchState state = null;
	
	public FanSwitch() {
		state = new SwitchState();
	}
	
	@Override
	public SwitchStates pressButton() {
		return state.toggleState();
	}
}
class LightSwitch implements Switch{
	private SwitchState state = null;
	public LightSwitch() {
		state = new SwitchState();
	}
	@Override
	public SwitchStates pressButton() {
		return state.toggleState();
	}
}

interface Switch{
	public SwitchStates  pressButton();
}
class SwitchState{
	private SwitchStates state = SwitchStates.OFF;
	public SwitchStates toggleState(){
		return state == SwitchStates.OFF?SwitchStates.ON:SwitchStates.OFF;
	}
	public SwitchStates getState(){
		return this.state;
	}
}
enum SwitchStates{
	ON, OFF
}