
package org.salgar.swf_statemachine.ssm.customersearchsm.guistate;

/**
* 
*/

public class CustomerSearchGuiState

		implements

			java.io.Serializable {

	private final static long serialVersionUID = 1832262558L;

	private java.lang.Boolean renderCustomerSearchInput = false;

	private java.lang.Boolean renderCustomerSearchRunning = false;

	private java.lang.Boolean renderCustomerSearchFound = false;

	private java.lang.Boolean renderCustomerSearchAuthentication = false;

	private java.lang.Boolean renderCustomerSearchJoin = false;

	private java.lang.Boolean renderCustomerSearchOrder = false;

	private java.lang.Boolean renderCustomerSearchOrderLoading = false;

	/**
	* 
	* @return The renderCustomerSearchInput as <code>java.lang.Boolean</code>
	*/

	public java.lang.Boolean getRenderCustomerSearchInput() {
		return renderCustomerSearchInput;
	}

	/**
	* 
	* @param renderCustomerSearchInput The renderCustomerSearchInput to set
	*/

	public void setRenderCustomerSearchInput(java.lang.Boolean renderCustomerSearchInput) {
		this.renderCustomerSearchInput = renderCustomerSearchInput;
	}

	/**
	* 
	* @return The renderCustomerSearchRunning as <code>java.lang.Boolean</code>
	*/

	public java.lang.Boolean getRenderCustomerSearchRunning() {
		return renderCustomerSearchRunning;
	}

	/**
	* 
	* @param renderCustomerSearchRunning The renderCustomerSearchRunning to set
	*/

	public void setRenderCustomerSearchRunning(java.lang.Boolean renderCustomerSearchRunning) {
		this.renderCustomerSearchRunning = renderCustomerSearchRunning;
	}

	/**
	* 
	* @return The renderCustomerSearchFound as <code>java.lang.Boolean</code>
	*/

	public java.lang.Boolean getRenderCustomerSearchFound() {
		return renderCustomerSearchFound;
	}

	/**
	* 
	* @param renderCustomerSearchFound The renderCustomerSearchFound to set
	*/

	public void setRenderCustomerSearchFound(java.lang.Boolean renderCustomerSearchFound) {
		this.renderCustomerSearchFound = renderCustomerSearchFound;
	}

	/**
	* 
	* @return The renderCustomerSearchAuthentication as <code>java.lang.Boolean</code>
	*/

	public java.lang.Boolean getRenderCustomerSearchAuthentication() {
		return renderCustomerSearchAuthentication;
	}

	/**
	* 
	* @param renderCustomerSearchAuthentication The renderCustomerSearchAuthentication to set
	*/

	public void setRenderCustomerSearchAuthentication(java.lang.Boolean renderCustomerSearchAuthentication) {
		this.renderCustomerSearchAuthentication = renderCustomerSearchAuthentication;
	}

	/**
	* 
	* @return The renderCustomerSearchJoin as <code>java.lang.Boolean</code>
	*/

	public java.lang.Boolean getRenderCustomerSearchJoin() {
		return renderCustomerSearchJoin;
	}

	/**
	* 
	* @param renderCustomerSearchJoin The renderCustomerSearchJoin to set
	*/

	public void setRenderCustomerSearchJoin(java.lang.Boolean renderCustomerSearchJoin) {
		this.renderCustomerSearchJoin = renderCustomerSearchJoin;
	}

	/**
	* 
	* @return The renderCustomerSearchOrder as <code>java.lang.Boolean</code>
	*/

	public java.lang.Boolean getRenderCustomerSearchOrder() {
		return renderCustomerSearchOrder;
	}

	/**
	* 
	* @param renderCustomerSearchOrder The renderCustomerSearchOrder to set
	*/

	public void setRenderCustomerSearchOrder(java.lang.Boolean renderCustomerSearchOrder) {
		this.renderCustomerSearchOrder = renderCustomerSearchOrder;
	}

	/**
	* 
	* @return The renderCustomerSearchOrderLoading as <code>java.lang.Boolean</code>
	*/

	public java.lang.Boolean getRenderCustomerSearchOrderLoading() {
		return renderCustomerSearchOrderLoading;
	}

	/**
	* 
	* @param renderCustomerSearchOrderLoading The renderCustomerSearchOrderLoading to set
	*/

	public void setRenderCustomerSearchOrderLoading(java.lang.Boolean renderCustomerSearchOrderLoading) {
		this.renderCustomerSearchOrderLoading = renderCustomerSearchOrderLoading;
	}

	/* (non-Javadoc) 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public String toString() {
		return org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString(this);
	}

}
