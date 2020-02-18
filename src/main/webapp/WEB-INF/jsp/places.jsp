<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Destination</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="dest">
						
						<fieldset class="form-group">
							<form:label path="name">Name</form:label>
							<form:input path="name" type="text" class="form-control"
								required="required" />
							
						</fieldset>

						<fieldset class="form-group">
							<form:label path="distance">Distance</form:label>
							<form:input path="distance" type="text" class="form-control"
								required="required" />
							
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="img">Image</form:label>
							<form:input path="img" type="text" class="form-control"
								required="required" />
							
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="url">URL</form:label>
							<form:input path="url" type="text" class="form-control"
								required="required" />
							
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>