$.extend({
	"initPermission" : function() {
		var permissionList = $.map(environment.permissionList, function(item) {
			return item.name;
		});

		$("[permission]").each(function(index, el) {
			// 有权限属性但没有对应权限就删除改元素
			var perm = $(el).attr("permission");
			if (perm && $.inArray(perm, permissionList) == -1) {
				$(el).remove();
			}
		});
	}
});

$(function() {
	$.initPermission();
});