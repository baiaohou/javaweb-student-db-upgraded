项目需求

    使用前端、数据库、JavaWeb 等技术并采用 MVC 设计模式实现学生信息管理系统，要求使用管理员账号密码登录后进行学员信息增加、学员信息修改、学员信息删除、学员信息查找、学员信息显示功能。
    其中学生信息有：学号、姓名、性别、出生日期、邮箱、备注。
    要求使用数据库连接池、分页显示等技术，并且还需要保证程序的可扩展性和可维护性。

三层架构

    模型层 (M)
        数据访问层 (M-Dao)
            com.lagou.dao：管理员用户表访问接口类 UserDao 
                           学员表访问接口类 StudentDao
            以及对应的 imp 目录下的实现类:
                            UserDaoImp
                            StudentDaoImp
        
        业务逻辑层 (M-Service)
            com.lagou.service： 管理员用户服务类 UserService 
                                学生信息服务类 StudentService
                                
        业务数据层 (M-Bean)
            com.lagou.bean： 学员表对象类 Student
                              用户对象类 User

    视图层 (V)
        web：存放前端代码的文件夹 

    控制层 (C)
        com.lagou.servlet: 
                IndexServlet - 检查是否登录，已经登录则重定向到main.jsp，没有登录则转到登录页面login.jsp
                LoginServlet - 验证登录信息，登录成功重定向到main.jsp，失败则跳转到登录页, 相对路径：/login
    其它
        工具类 com.lagou.util
        工厂类 com.lagou.factory
        测试类 com.lagou.test
