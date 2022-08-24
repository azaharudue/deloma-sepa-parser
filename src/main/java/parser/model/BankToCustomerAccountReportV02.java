package parser.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Azahar Hossain (c) 2022
 *
 */

@XmlType(name = "BankToCustomerAccountReportV02")
public class BankToCustomerAccountReportV02
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
	public BankToCustomerAccountReportV02 setGrpHdr(GroupHeader42 grpHdr)
	{
		this.grpHdr = grpHdr;
		return this;
	}

	@XmlElement(name = "Rpt")
	private List<AccountReport11> rpt;

	public List<AccountReport11> getRpt()
	{
		if (this.rpt == null)
			rpt = new ArrayList<AccountReport11>();
		return rpt;
	}

}
