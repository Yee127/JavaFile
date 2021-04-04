package Object_Oriented.异常;

/**
 * 异常处理：抓抛模型
 *
 * 处理方式：
 *          ① try - catch - finally
 *          ② throws
 *try - catch - finally 使用：
 *      try{
 *          可能出现异常的代码
 *      }catch（异常类型1 变量名1）{
 *          处理异常的方式
 *      }
 *      catch（异常类型2 变量名2）{
 *              处理异常的方式
 *          }
 *  catch（异常类型3 变量名3）{
 *              处理异常的方式
 *          }
 *  finally{
 *      一定会执行的代码
 *  }
 *
 *  ********************************
 *
 *  说明：
 *  finally可选
 *  try中异常匹配到catch中的异常时 即进入catch处理，一旦完成处理就跳出当前try——catch结构（在没有finally的情况下）
 *  catch中的异常类型 如果没有子父类关系，则位置随意
 *                  如果存在子父类关系，则要求子类一定在父类的上面。
 *  常用的异常对象处理方式：①String getMessage（）
 *                      ②printStackTrace（）
 *  在try结构声明的变量，在出了try结构后，就不能再被调用了
 */
public class ExceptionTest {
    public static void main(String[] args) {
        String str = "123";
        str = "abd";
        try {
            int n = Integer.parseInt(str);
        }catch (NullPointerException e){
            System.out.println("空指针异常");
        } catch (NumberFormatException e){
            System.out.println("数值异常");
        }catch (Exception e){
            System.out.println("出现异常了");
        }

        System.out.println("hhhhhhhhh");
    }

}
