import java.sql.*;
import java.util.ArrayList;
import java.util.List;


class MySqlManagerDAO implements ProductDAO {

    @Override
    public List<Product> showAllProducts() {
        String sql = "SELECT * " +
                "FROM products";
        //container for the ResultSet
        List<Product> list = new ArrayList<>();

        try (Connection connnectToDB = MySqlConnectorJ.getConnection();
             Statement stmt = connnectToDB.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // loop through the result set
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getInt(4)
                ));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void addProduct(Product product) {
        String sqlUpdate = "INSERT INTO products "
                +"VALUES (?,?,?,?)";
        try(Connection connectToDB = MySqlConnectorJ.getConnection();
            PreparedStatement pstmt = connectToDB.prepareStatement(sqlUpdate)){
            pstmt.setInt(1,product.getId());
            pstmt.setString(2,product.getName());
            pstmt.setFloat(3,product.getPrice());
            pstmt.setInt(4,product.getQuantity());

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row(s) affected %d", rowAffected));

        }catch (SQLException sqlEx){
            System.out.println(sqlEx.getMessage());
        }
    }

    @Override
    public void removeProduct(int id){

        String sqlUpdate = "DELETE FROM products "+
                "WHERE id=?";

        try(Connection connectToDB = MySqlConnectorJ.getConnection();
        PreparedStatement pstmt = connectToDB.prepareStatement(sqlUpdate)) {
            //prepare data for update
            pstmt.setInt(1, id);

            int rowAffected = pstmt.executeUpdate();

            System.out.println(String.format("Row(s) affected %d",rowAffected));
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void increaseQuantity(int id, int quantity) {

        String sqlUpdate = "UPDATE products "
                + "SET quantity = quantity + ? "
                + "WHERE id = ?";

        try (Connection conn = MySqlConnectorJ.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

            // prepare data for update
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, id);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row(s) affected %d", rowAffected));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void decreaseQuantity(int id, int quantity) {

        String sqlUpdate = "UPDATE products "
                + "SET quantity = quantity - ? "
                + "WHERE id = ?";

        try (Connection conn = MySqlConnectorJ.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

            // prepare data for update
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, id);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void setPrice(int id, float price) {

        String sqlUpdate = "UPDATE products "
                + "SET price = ? "
                + "WHERE id = ?";

        try (Connection conn = MySqlConnectorJ.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

            // prepare data for update
            pstmt.setFloat(1, price);
            pstmt.setInt(2, id);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void setName(int id, String name) {

        String sqlUpdate = "UPDATE products "
                + "SET product = ? "
                + "WHERE id = ?";

        try (Connection conn = MySqlConnectorJ.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

            // prepare data for update
            pstmt.setString(1, name);
            pstmt.setInt(2, id);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public float productTotalValue(int id) {

        String sql = "SELECT price*quantity "
                + "FROM products "
                + "WHERE id = ?";

        float totalValue=-1;

        try (Connection conn = MySqlConnectorJ.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // prepare data for update
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            totalValue = rs.getFloat(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return totalValue;
    }

    @Override
    public float productsTotalValue(){
        String sql = "SELECT sum(price*quantity) "
                +"FROM products";

        float totalValue = -1;

        try(Connection connectToDB = MySqlConnectorJ.getConnection();
            Statement stmt = connectToDB.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            totalValue = rs.getFloat(1);

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return totalValue;
    }


}
