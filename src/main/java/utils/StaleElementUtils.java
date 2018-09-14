package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaleElementUtils {
//	private static final Logger LOGGER = LoggerFactory.getLogger(UIUtils.class);
    public static WebElement refreshElement(WebElement elem,WebDriver driver){
        if(!isElementStale(elem))
            return elem;
        Object lastObject = null;
        try{
            String[] arr = elem.toString().split("->");
            List<String> newStr = new ArrayList<String>();
            for(String s:arr){
                String newstr = s.trim().replaceAll("^\\[+", "").replaceAll("\\]+$","");
                String[] parts = newstr.split(": ");
                String key = parts[0];
                String value = parts[1];
                int leftBracketsCount = value.length() - value.replace("[", "").length();
                int rightBracketscount = value.length() - value.replace("]", "").length();
                if(leftBracketsCount-rightBracketscount==1)
                    value = value + "]";
                if(lastObject==null){
                	lastObject = driver;
                }else{
                    lastObject = getWebElement(lastObject, key, value);
                }
            }
        }catch(Exception e){
//            LOGGER.error("Error in Refreshing the stale Element.");
        }
        return (WebElement)lastObject;
    }

    public static boolean isElementStale(WebElement e){
        try{
            e.isDisplayed();
            return false;
        }catch(StaleElementReferenceException ex){
            return true;
        }
    }

    private static WebElement getWebElement(Object lastObject, String key, String value){
        WebElement element = null;
        try {
            By by = getBy(key,value);
            Method m = getCaseInsensitiveDeclaredMethod(lastObject,"findElement");
            element = (WebElement) m.invoke(lastObject,by);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return element;
    }
    

    private static By getBy(String key, String value) throws InvocationTargetException, IllegalAccessException {
        By by = null;
        Class clazz = By.class;
        String methodName = key.replace(" ","");
        Method m = getCaseInsensitiveStaticDeclaredMethod(clazz,methodName);
        return (By) m.invoke(null,value);
    }
    
    private static Method getCaseInsensitiveDeclaredMethod(Object obj, String methodName) {
        Method[] methods = obj.getClass().getMethods();
        Method method = null;
        for (Method m : methods) {
            if (m.getName().equalsIgnoreCase(methodName)) {
                method = m;
                break;
            }
        }
        if (method == null) {
            throw new IllegalStateException(String.format("%s Method name is not found for this Class %s", methodName, obj.getClass().toString()));
        }
        return method;
    }
    
    private static Method getCaseInsensitiveStaticDeclaredMethod(Class clazz, String methodName) {
        Method[] methods = clazz.getMethods();
        Method method = null;
        for (Method m : methods) {
            if (m.getName().equalsIgnoreCase(methodName)) {
                method = m;
                break;
            }
        }
        if (method == null) {
            throw new IllegalStateException(String.format("%s Method name is not found for this Class %s", methodName, clazz.toString()));
        }
        return method;
    }
}
