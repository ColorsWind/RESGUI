package org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI;

import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class InventoryInteractResponse {

	private final Type type;
	private final AbstractGUI gui;
	public InventoryInteractResponse(Type type,AbstractGUI gui) {
		this.type = type;
		this.gui = gui;
	}
	
	public Type getType(){
		return type;
	}
	
	public AbstractGUI getGUI(){
		return gui;
	}
	
	public enum Type{
		DoNothing,Close,OpenAnother,RefreshButton;
	}
	
}
