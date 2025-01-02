/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import thogakade.db.DBConnection;
import thogakade.model.Customer;
import thogakade.model.OrderDetail;

public class OrderDetailController {

    public static boolean addOrderDetail(ArrayList<OrderDetail> orderDetailsList) throws ClassNotFoundException, SQLException {
        for (OrderDetail orderDetail : orderDetailsList) {
            boolean isAddOrderDetail = addOrderDetail(orderDetail);
            if (!isAddOrderDetail) {
                return false;
            }
        }
        return !orderDetailsList.isEmpty();
    }

    public static boolean addOrderDetail(OrderDetail orderDetail) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("insert into OrderDetail values(?,?,?,?)");
        stm.setObject(1, orderDetail.getOrderId());
        stm.setObject(2, orderDetail.getItemCode());
        stm.setObject(3, orderDetail.getQty());
        stm.setObject(4, orderDetail.getUnitPrice());
        return stm.executeUpdate() > 0;
    }
}
