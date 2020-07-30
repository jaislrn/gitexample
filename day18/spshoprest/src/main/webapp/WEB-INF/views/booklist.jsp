<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="themes/redmond/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" />
	<link href="scripts/jtable/themes/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />
	<script src="scripts/jquery-1.6.4.min.js" type="text/javascript"></script>
    <script src="scripts/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
    <script src="scripts/jtable/jquery.jtable.js" type="text/javascript"></script>
	
  </head>
  <body>
	<div id="BookTableContainer" style="width: 1000px;"></div>
	<script type="text/javascript">

		$(document).ready(function () {
		    //Prepare jTable
			$('#BookTableContainer').jtable({
				title: 'Table of Books',
				actions: {
					listAction: 'jtable/books',
					createAction: 'jtable/newbook',
					updateAction: 'jtable/editbook',
					deleteAction: 'jtable/delbook'
				},
				fields: {
					id: {
						title: 'ID',
						key: true,
						create: true,
						edit: false,
						list: true,
						width: '10%'
					},
					name: {
						title: 'NAME',
						width: '25%'
					},
					author: {
						title: 'AUTHOR',
						width: '25%'
					},
					subject: {
						title: 'SUBJECT',
						width: '15%'
					},
					price: {
						title: 'PRICE',
						width: '15%'
					},
					image: {
						title: 'IMAGE',
						width: '15%',
						edit: false,
						create: false,
						display: function (data) {
							return '<img alt=\'NA\' width=\'75\' height=\'100\' src=\'download?id='+data.record.id+'\'/><br/><a href=\'upload?id='+data.record.id+'\'>Replace</a>';
					    }
					}
				}
			});

			//Load books list from server
			$('#BookTableContainer').jtable('load');
		});
	</script>
	<br/>
	<a href="logout">Sign Out</a>
  </body>
</html>

