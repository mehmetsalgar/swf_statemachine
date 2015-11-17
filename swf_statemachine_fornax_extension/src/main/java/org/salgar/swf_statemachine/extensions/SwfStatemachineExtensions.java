package org.salgar.swf_statemachine.extensions;

import org.eclipse.uml2.uml.VisibilityKind;

public class SwfStatemachineExtensions {
	public static String getVisiblityName(VisibilityKind visibilityKind) {
		return visibilityKind.getLiteral();
	}
	public static String removeSM(String smToRemove) {
		if(smToRemove != null) {
			return smToRemove.replace("SM", "");
		}
		return smToRemove;
	}

}
