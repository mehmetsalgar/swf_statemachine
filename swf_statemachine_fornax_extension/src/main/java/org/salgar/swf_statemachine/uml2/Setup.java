package org.salgar.swf_statemachine.uml2;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.uml2.uml.UMLPackage;

public class Setup
	extends org.eclipse.xtend.typesystem.uml2.Setup {
	private static final String UML2_500_NS_URI = "http://www.eclipse.org/uml2/5.0.0/UML";

	@Override
	public void setStandardUML2Setup(boolean b) {
		super.setStandardUML2Setup(b);
		EPackage.Registry.INSTANCE.put(UML2_500_NS_URI, EPackage.Registry.INSTANCE.get(UMLPackage.eINSTANCE.getNsURI()));
	}
}
