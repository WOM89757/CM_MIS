//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\dao\\DAO.java



package com.WM.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import com.WM.dao.Model.Item;
import com.WM.dao.Model.bill_Detail;
import com.WM.dao.Model.billinfo;
import com.WM.dao.Model.customer;
import com.WM.dao.Model.gdinfo;
import com.WM.dao.Model.goodsinfo;
import com.WM.dao.Model.serviceItemsinfo;


public class DAO 
{
   protected static String dbClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   
   /**
   SQL���ݿ������������
    */
   protected static String dbUrl = "jdbc:sqlserver://localhost:1433;";
   
   /**
   ����SQL���ݿ��·��
    */
   protected static String dbUser = "ck";
   
   /**
   ����SQL���ݿ���û���
    */
   protected static String dbPwd = "a123456";
   
   /**
   ����SQL���ݿ������
    */
   protected static String dbName = "db_database28";
   
   /**
   ����SQL���ݿ��е�ʵ��(db_database27)
    */
   protected static String second = null;
   public static Connection conn = null;
   
   /**
   @roseuid 5D0B97B30206
    */
   public DAO() 
   {
    
   }
   
   static 
   {// ��̬��ʼ��Dao��
		try {
			if (conn == null) {
				
//				Class.forName(dbClassName);// ʵ����MySQL���ݿ������
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yunchuang?useSSL=false","root","root");
				
				//conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);// ����MySQL���ݿ�
				//System.out.println("���ݿ���سɹ�!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�뽫SQL��JDBC���������Ƶ�lib�ļ����С�");// �����쳣�󣬵�����ʾ��
			System.exit(-1);// ϵͳֹͣ����
		} catch (Exception e) {
			e.printStackTrace();
		}    
   }
   
   /**
   ִ��ָ����ѯ
   @param QueryStr
   @return java.sql.ResultSet
   @roseuid 5D0B97B30210
    */
   public static ResultSet query(String QueryStr) 
   {
	  // System.out.println(QueryStr);
	   ResultSet set = findForResultSet(QueryStr);
		return set;    
   }
   
   /**
   @param sql
   @return java.util.List
   @roseuid 5D0B97B30228
    */
   public static List findForList(String sql) 
   {
		List<List> list = new ArrayList<List>();
		//System.out.println(sql);
		ResultSet rs = findForResultSet(sql);
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int colCount = metaData.getColumnCount();
			while (rs.next()) {
				List<String> row = new ArrayList<String>();
				for (int i = 1; i <= colCount; i++) {
					String str = rs.getString(i);
					if (str != null && !str.isEmpty())
						str = str.trim();
					row.add(str);
				}
				list.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;    
   }
// �����Ʒ
	public static boolean addSp(goodsinfo spInfo) {
		if (spInfo == null)
			return false;
		return insert("insert goodsinfo values(" + spInfo.getGoodsId() + ",'"
				+ spInfo.getGoodsClassic() + "','" + spInfo.getGoodsName() + "',"
				+ spInfo.getSellingprice() + ",'','')");
	}
	public static boolean addSp(serviceItemsinfo spInfo) {
		if (spInfo == null)
			return false;
		return insert("insert serviceItemsinfo values(" + spInfo.getServiceitemId() + ",'"
				+ spInfo.getServiceitemClassic() + "','" + spInfo.getServiceName() + "',"
				+ spInfo.getSellingprice() + ")");
	}

	public static int delete(String sql) {
		return update(sql);
	}
	// ������Ʒ
		public static int updateSp(goodsinfo spInfo) {
			return update("update goodsinfo set "+"goodsClassic='"
					+ spInfo.getGoodsClassic() + "',goodsName='" + spInfo.getGoodsName() + "',sellingprice="
					+ spInfo.getSellingprice() +"where goodsId="+spInfo.getGoodsId()+";");
		}
		public static int updaterkSp(goodsinfo spInfo) {
			return update("update goodsinfo set Stock=" + spInfo.getStock() +" where goodsId="+spInfo.getGoodsId()+";");
		}
		public static int updateSp(serviceItemsinfo spInfo) {
			return update("update serviceItemsinfo set serviceitemId=" + spInfo.getServiceitemId() + ",serviceitemClassic='"
					+ spInfo.getServiceitemClassic() + "',serviceName='" + spInfo.getServiceName() + "',sellingprice="
					+ spInfo.getSellingprice() +";");
		}
		// ��ȡ������Ʒ��Ϣ
		public static List getSpInfos() {
			List list = findForList("select * from goodsinfo");
			return list;
		}
		public static List getserviceItemsinfoInfos() {
			List list = findForList("select * from serviceItemsinfo");
			return list;
		}
		// ��ӿͻ���Ϣ�ķ���
		public static boolean addKeHu(customer khinfo) {
			if (khinfo == null)
				return false;
			return insert("insert customer values('" + khinfo.getCardId() + "','"
					+ khinfo.getUserName() + "','" 	+ khinfo.phoneNumber + "',0,0,"+khinfo.getCardId()+")");
		}
		// �޸Ŀͻ���Ϣ�ķ���
		public static int updateKeHu(customer khinfo) {
			return update("update customer set userName='" + khinfo.getUserName() + "',phoneNumber="
					+ khinfo.getPhoneNumber() + " where cardId="+ khinfo.getCardId()+";");
		}


   /**
   �������
   @param sql
   @return boolean
   @roseuid 5D0B97B30257
    */
   public static boolean insert(String sql) 
   {
		boolean result = false;
		try {
			//System.out.println(sql);
			Statement stmt = conn.createStatement();
			result = stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;    
   }
   
 
   /**
   ��������
   @param sql
   @return int
   @roseuid 5D0B97B3028C
    */
   public static int update(String sql) 
   {
		int result = 0;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;    
   }
   
   public static boolean insertgdInfo(billinfo sellMain) 
   {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// ������������¼
			insert("insert into gdinfo values('" + sellMain.getBillId()
					+ "','" + sellMain.getDate()
					+ "','" + sellMain.getPrice()
					+ "','" +sellMain.getUserName()+ "','admin');");
			Set<bill_Detail> rkDetails = sellMain.getbillDetails();
			for (Iterator<bill_Detail> iter = rkDetails.iterator(); iter
					.hasNext();) {
				bill_Detail details = iter.next();
				// ���������ϸ���¼
				insert("insert into gd_Detail values('"
						+ sellMain.getBillId() + "','" + details.getSpid()
						+ "','"+details.getSpname()+"'," + details.getDj() + "," + details.getSl()+","+details.getDiscount()+","+details.getSprice() +");");
			

			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;    
   }
    
   

 
   /**
   ��ȡ�����Ʒ��Ϣ
   @param item
   @return com.WM.dao.Model.kucun
   @roseuid 5D0B97B302F4
    */
  /* public static kucun getKucun(Item item) 
   {
		String where = "spname='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_kucun where " + where);
		kucun kucun = new kucun();
		try {
			if (rs.next()) {
				kucun.setId(rs.getString("id"));
				kucun.setName(rs.getString("name"));
			/*	kucun.setJc(rs.getString("jc"));
				kucun.setBz(rs.getString("bz"));
				kucun.setCd(rs.getString("cd"));
				kucun.setDj(rs.getDouble("dj"));
				kucun.setDw(rs.getString("dw"));
				kucun.setGg(rs.getString("gg"));
				kucun.setKcsl(rs.getInt("kcsl"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kucun;    
   }*/
   
   
   /**
   ��ȡ���пͻ���Ϣ
   @return java.util.List
   @roseuid 5D0B97B30320
    */
   public static List getKhInfos() 
   {
		List list = findForList("select cardId,userName from customer");
		return list;    
   }
	// ��ȡ�ͻ���Ϣ
	public static customer getKhInfo(Item item) {
		String where = "userName='" + item.getName() + "'";
		if (item.getId() != null)
			where = "cardId='" + item.getId() + "'";
		customer info = new customer();
		ResultSet set = findForResultSet("select * from customer where "
				+ where);
		try {
			if (set.next()) {
				info.setCardId(set.getInt("cardId"));
				info.setUserName(set.getString("userName").trim());
				info.setPhoneNumber(Long.valueOf(set.getLong("phoneNumber")));
				info.setMoney((set.getFloat("money")));
				info.setIntegral((set.getInt("integral")));
				info.setPassword(set.getString("password").trim());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	// ��ȡ�����������ID
	public static String getSellMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "billinfo", "SY", "billId");
	}
	// ��ȡ�����������ID
	private static String getMainTypeTableMaxId(Date date, String table,
			String idChar, String idName) {
		String dateStr = date.toString().replace("-", "");
		String id = idChar + dateStr;
		String sql = "select max(" + idName + ") from " + table + " where "
				+ idName + " like '" + id + "%'";
		ResultSet set = query(sql);
		String baseId = null;
		try {
			if (set.next())
				baseId = set.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}


		baseId = baseId == null ? "000" : baseId.substring(baseId.length()-15);
		baseId=baseId.trim();
		int idNum = Integer.valueOf(baseId)+1;
		//System.out.println(idNum);
		id += String.format("%03d", idNum);
		//System.out.println(id);
		return id;
	}
	// ��ȡ�����������ID
	public static String getgdMainMaxId(Date date) {
		return getgdMainTypeTableMaxId(date, "gdinfo", "GD", "billId");
	}
	// ��ȡ�����������ID
	private static String getgdMainTypeTableMaxId(Date date, String table,
			String idChar, String idName) {
		String dateStr = date.toString().replace("-", "");
		String id = idChar + dateStr;
		String sql = "select max(" + idName + ") from " + table + " where "
				+ idName + " like '" + id + "%'";
		ResultSet set = query(sql);
		String baseId = null;
		try {
			if (set.next())
				baseId = set.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}


		baseId = baseId == null ? "000" : baseId.substring(baseId.length()-15);
		baseId=baseId.trim();
		int idNum = Integer.valueOf(baseId)+1;
		//System.out.println(idNum);
		id += String.format("%03d", idNum);
		//System.out.println(id);
		return id;
	}
 
   
   /**
   ��֤��¼
   @param userStr
   @param passStr
   @return boolean
   @throws java.sql.SQLException
   @roseuid 5D0B97B3037C
    */
   public static boolean checkLogin(String userStr, String passStr) throws SQLException 
   {
		ResultSet rs = findForResultSet("select * from staff where staffId='"
				+ userStr + "' and password='" + passStr + "'");
		if (rs == null)
			return false;
		return rs.next();    
   }
   
   /**
   @param sql
   @return java.sql.ResultSet
   @roseuid 5D0B97B303A8
    */
   public static ResultSet findForResultSet(String sql) 
   {
		if (conn == null)
			return null;
		long time = System.currentTimeMillis();
		ResultSet rs = null;
		//System.out.println(sql);
		try {
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			second = ((System.currentTimeMillis() - time) / 1000d) + "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;    
   }
}
