package remository;

import remository.custom.impl.EmployeeDaoImpl;
import remository.custom.impl.ItemDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){

    }
    public static DaoFactory getDaoFactory(){
        return daoFactory!=null?daoFactory:(daoFactory=new DaoFactory());
    }
    public enum DaoType{
        ITEM,EMPLOYEE
    }
    public <T extends SuperDao>T getDaoType(DaoType type){
        switch (type){
                        //This is a type cast
            case ITEM:return (T)new ItemDaoImpl();
            case EMPLOYEE:return (T) new EmployeeDaoImpl();
            default:return null;
        }
    }
}
