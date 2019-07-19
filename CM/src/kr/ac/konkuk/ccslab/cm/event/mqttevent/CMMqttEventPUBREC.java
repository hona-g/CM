package kr.ac.konkuk.ccslab.cm.event.mqttevent;

import java.nio.ByteBuffer;

/**
 * This class represents a CM event that the variable header and payload of 
 * MQTT PUBREC packet.
 * @author CCSLab, Konkuk University
 *
 */
public class CMMqttEventPUBREC extends CMMqttEventFixedHeader {

	//////////////////////////////////////////////////
	// member variables (variable header)
	int m_nPacketID;

	//////////////////////////////////////////////////
	// constructors

	public CMMqttEventPUBREC()
	{
		// initialize CM event ID
		m_nID = CMMqttEvent.PUBREC;
		// initialize fixed header
		m_packetType = CMMqttEvent.PUBREC;
		m_flag = 0;
		// initialize variable header
		m_nPacketID = -1;
	}
	
	public CMMqttEventPUBREC(ByteBuffer msg)
	{
		this();
		unmarshall(msg);
	}
	
	//////////////////////////////////////////////////
	// setter/getter (variable header)

	/**
	 * sets MQTT packet ID.
	 * @param nID - packet ID.
	 */
	public void setPacketID(int nID)
	{
		m_nPacketID = nID;
	}
	
	/**
	 * gets MQTT packet ID.
	 * @return packet ID.
	 */
	public int getPacketID()
	{
		return m_nPacketID;
	}

	//////////////////////////////////////////////////
	// overridden methods (variable header)

	@Override
	protected int getVarHeaderByteNum()
	{
		return 2;	// packet ID
	}

	@Override
	protected void marshallVarHeader()
	{
		putInt2BytesToByteBuffer(m_nPacketID);
	}

	@Override
	protected void unmarshallVarHeader(ByteBuffer buf)
	{
		m_nPacketID = getInt2BytesFromByteBuffer(buf);
	}

	//////////////////////////////////////////////////
	// overridden methods (payload)

	// No payload in this packet

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
		StringBuffer strBufVarHeader = new StringBuffer();
		strBufVarHeader.append("CMMqttEventPUBREC {");
		strBufVarHeader.append(super.toString()+", ");
		strBufVarHeader.append("\"packetID\": "+m_nPacketID);
		strBufVarHeader.append("}");
		
		return strBufVarHeader.toString();
	}
}