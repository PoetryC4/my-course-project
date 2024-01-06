
//校验姓名
function checkName (rule, value, callback){
  if (value === "") {
    callback(new Error("请输入姓名"))
  } else if (value.length > 12) {
    callback(new Error("账号长度应是1-12"))
  } else {
    callback()
  }
}


function checkEmail (rule, value, callback){
  let emailReg = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (value === "") {
    callback(new Error("请输入电子邮箱"))
  } else if (!emailReg.test(value)) {//引入methods中封装的检查手机格式的方法
    callback(new Error("请输入正确的电子邮箱!"))
  } else {
    callback()
  }
}