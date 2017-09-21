
function isChinese(txt)
{
	var temp=/^[\u4E00-\u9FA5]{1,20}$/;
	//var temp=/\w$/;temp.
    return temp.test(txt);
}
function isEmail(txt)
{
	var temp=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	return temp.test(txt);
}
