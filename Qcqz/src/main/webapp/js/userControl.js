
$(function() {
	$('#userTree').tree({
		data: [
				{"id" : "1",
				"text" : "用户目录",
				"pid" : null,
				"children":[
							{
								"id" : "1",
								"text" : "11111",
								"pid" : 1,
							}, {
								"id" : "2",
								"text" : "22222",
								"pid" : 1,
							}, {
								"id" : "3",
								"text" : "33333",
								"pid" : 1,
							}, {
								"id" : "4",
								"text" : "44444",
								"pid" : 1,
							}, {
								"id" : "5",
								"text" : "5555",
								"pid" : 1,
							}, {
								"id" : "6",
								"text" : "66666",
								"pid" : 1,
							}]
				}],
				onClick: function(node){
					if(node.id == "1"){
						$('#userTable').datagrid({
						    columns:[[
								{field:'xignming',title:'Code',width:100},
								{field:'name',title:'Name',width:100},
								{field:'price',title:'Price',width:100}
						    ]]
						});
					}else{
						
					}
				}
	});
});