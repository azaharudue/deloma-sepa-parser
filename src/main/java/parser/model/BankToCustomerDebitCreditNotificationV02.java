package parser.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Azahar Hossain (c) 2022
 *
 */

@XmlType(name = "BankToCustomerDebitCreditNotificationV02")
/**
 * 
 * @see GroupHeader42, AccountNotification2
 *
 */
public class BankToCustomerDebitCreditNotificationV02
{

	@XmlElement(name = "GrpHdr", required = true)
	public GroupHeader42 grpHdr;

	/**
	 * @return the grpHdr
	 */
	public GroupHeader42 getGrpHdr()
	{
		return grpHdr;
	}

	/**
	 * @param grpHdr
	 *            the grpHdr to set
	 */
	public BankToCustomerDebitCreditNotificationV02 setGrpHdr(GroupHeader42 grpHdr)
	{
		this.grpHdr = grpHdr;
		return this;
	}

	@XmlElement(name = "Ntfctn", required = true)
	private List<AccountNotification2> ntfctn;

	/**
	 * 
	 * @return a new ArrayList if {@link #ntfctn} is null
	 */
	public List<AccountNotification2> getNtfctn()
	{
		if (ntfctn == null)
		{
			ntfctn = new ArrayList<AccountNotification2>();
		}
		return this.ntfctn;
	}

	/**
	 * Adds a new item to the ntfctn list.
	 * 
	 * @see #getNtfctn()
	 * 
	 */
	public BankToCustomerDebitCreditNotificationV02 addNtfctn(AccountNotification2 ntfctn)
	{
		// handles null list then add the new Object to the list.
		getNtfctn().add(ntfctn);
		return this;
	}

	@Override
	public String toString()
	{
		return "BankToCustomerDebitCreditNotificationV02 [ntfctn=" + ntfctn + "]";
	}

}
