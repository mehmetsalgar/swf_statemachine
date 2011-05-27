package org.salgar.swf_statemachine.extensions;

import org.eclipse.uml2.uml.VisibilityKind;

public class SwfStatemachineExtensions {
	public static String getVisiblityName(VisibilityKind visibilityKind) {
		return visibilityKind.getLiteral();
	}
}
