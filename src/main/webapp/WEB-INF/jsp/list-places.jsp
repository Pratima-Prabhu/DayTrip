<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
	<br>
	<br>
	<br>
	<div class="row">
	
	<div class="col-lg-8">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of Destinations</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				
				
					<c:forEach items="${dest}" var="des">
						<tr>
							<td>Name: <a href="/places/${des.name}">${des.name}</a></td>
							<td>Distance: ${des.distance}</td>
							<td>URL: ${des.url}</td>
							<td><img src="${des.img}" height="50" width="50"/></td>
						</tr>
					</c:forEach>

			</table>
		</div>
	</div>
</div>
<div class="col-lg-2"></div>
<div class="col-lg-2">
	<br>
	<br>
	<br>
	<br>
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/places/add">Add Destinations</a>
	</div>

</div>
</div>
</div>
<%@ include file="common/footer.jspf"%>