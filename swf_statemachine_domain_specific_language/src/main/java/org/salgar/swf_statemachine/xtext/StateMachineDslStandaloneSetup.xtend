/*
 * generated by Xtext 2.9.1
 */
package org.salgar.swf_statemachine.xtext


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class StateMachineDslStandaloneSetup extends StateMachineDslStandaloneSetupGenerated {

	def static void doSetup() {
		new StateMachineDslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}