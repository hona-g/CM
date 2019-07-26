package kr.ac.konkuk.ccslab.cm.event.mqttevent;

import java.nio.ByteBuffer;

/**
 * This class represents a CM event that the variable header and payload of 
 * MQTT PINGRESP packet.
 * @author CCSLab, Konkuk University
 *
 */
public class CMMqttEventPINGRESP extends CMMqttEventFixedHeader {

	//////////////////////////////////////////////////
	// constructors

	public CMMqttEventPINGRESP()
	{
		// initialize CM event ID
		m_nID = CMMqttEvent.PINGRESP;
		// initialize fixed header
		m_packetType = CMMqttEvent.PINGRESP;
		m_flag = 0;
	}
	
	public CMMqttEventPINGRESP(ByteBuffer msg)
	{
		this();
		unmarshall(msg);
	}
	
	//////////////////////////////////////////////////
	// overridden methods (variable header)

	@Override
	protected int getVarHeaderByteNum()
	{
		return 0;
	}

	@Override
	protected void marshallVarHeader(){}

	@Override
	protected void unmarshallVarHeader(ByteBuffer buf){}

	//////////////////////////////////////////////////
	// overridden methods (payload)

	@Override
	protected int getPayloadByteNum()
	{
		return 0;
	}

	@Override
	protected void marshallPayload(){}

	@Override
	protected void unmarshallPayload(ByteBuffer buf){}

	//////////////////////////////////////////////////
	// overridden methods

	@Override
	public String toString()
	{
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("CMMqttEventPINGRESP {");
		strBuf.append(super.toString()+"}");
		
		return strBuf.toString();
	}

}