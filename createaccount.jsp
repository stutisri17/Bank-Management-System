<html>
<body>
<br><br>

	   <form action=createaccount method=post enctype="multipart/form-data" onSubmit="return onsubmitt()">
		
		<table align=center>
		<tr><td><h1><u><b>Create New Account</b></u></h1></td></tr>
	   
		 <tr><td>Enter Name:<br>
		<input type=text name="name" id="name" maxlength=35></td></tr>

	    <tr><td>Enter Gender:<br>
		M:<input type=radio name="gender" id=gender_m value=M>
		F:<input type=radio name="gender" id=gender_f value=F>
	</td></tr>
 
	 <tr><td>Enter Phone No.:<br>
		<input type=text name="phoneno" id="phoneno" maxlength=10></td></tr>

	 <tr><td>Enter Email Id:<br>
		<input type=text name="emailid" id="emailid" maxlength=50></td></tr>
	 
		<tr><td>Enter Address:<br>
		<textarea name=address id=address rows=5 cols=35 maxlenght=200></textarea></td></tr>

		 <tr><td>Enter SSNO/Aadhaar No.:<br>
		<input type=text name=ssno id=ssno maxlength=15></td></tr>

		 <tr><td>Enter PAN NO.:<br>
		<input type=text name=panno id=panno maxlength=10></td></tr>

		 <tr><td>Enter DOB:<br>
		<input type=date name=dob id=dob maxlength=10></td></tr>
	
	 <tr><td>Select Qualifications:<br>
		Int.<input type=checkbox name=intermediate id=intermediate value=Intermediate>
		Graduation<input type=checkbox name=graduation id=graduation value=Graduation>
		Post Graduation<input type=checkbox name=postgraduation id=postgraduation value=PostGraduation>
	</td></tr>	

		 <tr><td>Account Type:<br>
		<select name=account_type id=account_type>
		<option value="Savings">Savings</option>
		<option value="Current">Current</option>
		</select>
		</td></tr>

		<tr><td>
		Select Image To Upload <input type="file" name="account_image"><br><br>
		
		</td></tr>

		<tr><td>
		<input type=submit value=Register>
		</td></tr>
</table>
</form>

	<script>
	function onsubmitt()
	{
	    try{
	    //Validation of name
	
		var name = document.getElementById("name").value;
		if(name.length<3)
		{
		   alert("Name Required");
		   document.getElementById("name").focus();
		   return false;
		}
		if(name.length>35)
		{
                   alert("Name Input Limit Exceeds, Max. Character Allowed Is 35");
		   document.getElementById("name").focus();
		   return false;
		}
		
		for(var loop=0; loop<name.length; loop++)
		{
		   var ch = name.charAt(loop);
		   if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch==' ') || (ch=='.'))
			{}
		    else{
			    alert("Invalid Characters In Name Field");
			     document.getElementById("name").focus();
			     return false;
			}
		}
		
		    var new_name="";
		    for(var loop=0; loop<name.length; loop++)
	 	    {
			var ch = name.charAt(loop);
			if(loop==0)
			{
			  if(ch>='a' && ch<='z')
			   {
			     ch=ch.toUpperCase();
			    }
			  }
			else if(ch==' ')
			{
			  ch=name.charAt(loop+1);
			   if(ch>='a' && ch<='z')
			    ch=' '+ch.toUpperCase();
			    loop++;	
			}
		    new_name = new_name + ch;
        	}
		document.getElementById("name").value=new_name;

       //validation for gender

		var is_gender_selected=0;
		var gender_m = document.getElementById("gender_m").checked;
		if(gender_m == true)
		is_gender_selected=1;

		var gender_f = document.getElementById("gender_f").checked;
		if(gender_f == true)
		is_gender_selected=1;

			if(is_gender_selected==0)
			{
			alert("Gender Field Is Mandatory, Please Select Gender");
			document.getElementById("gender_m").focus();
			return false;	
			}

      //validation For Phone No.
	
	 var phoneno = document.getElementById("phoneno").value;
	  if(phoneno.length != 10)
             {
		alert("Invalid Character in Phone no., Phone No. Length Is not 10");
		document.getElementById("phoneno").focus();
		return false;
		}
		if(isNaN(phoneno))
		{
		   alert("Invalid Character In Phoneno, Only Number Allowed");
		    document.getElementById("phoneno").focus();
		   return false;
		}
			for(var loop=0; loop<phoneno.length; loop++)
			{
			  var ch= phoneno.charAt(loop);
			   if(ch>='0' && ch<='9')
			   {}	
			   else{
				alert("Invalid Character In Phoneno, Only Numbers Allowed");
				document.getElementById("phoneno").focus();
				return false;
				}
			}
				var ch = phoneno.charAt(0);
				if(ch>='0' && ch<='5')
				{
				alert("First Character In Phoneno Must Be Greater Than 5");
				document.getElementById("phoneno").focus();
				return false;
				}

		//validation for emailid
		
		var emailid = document.getElementById("emailid").value;
		if(emailid.length<8)
		{
		  alert("Invalid Email-ID, It Must Greater Than 8 Character");
		  document.getElementById("emailid").focus();
		  return false;
		}

		var check = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if(!check.test(emailid))
		{
		alert("Invalid Email-ID");
		return false;
		}
		
     //validation for address

		var address =  document.getElementById("address").value;
		if(address.length<10)
		{
		alert("Invalid Address, More Data Required");
		document.getElementById("address").focus();
		return false;
		}
		
		for(var loop=0; loop<address.length; loop++)
		{
			var ch = address.charAt(loop);
			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch==' ') || (ch=='-') || (ch==',')|| (ch=='.') || (ch=='\n') || (ch>='0' && ch<='9'))
			{}
			else{
				alert("Invalid Characters in Address");
				document.getElementById("address").focus();
				return false;
			}	
		}
           
		//validation for aadhaar no.

		var ssno = document.getElementById("ssno").value;
	      if(ssno.length != 15)
             {
		alert("Invalid Character in AADHAAR, AADHAAR Length Is not 15");
		document.getElementById("ssno").focus();
		return false;
		}
		if(isNaN(ssno))
		{
		   alert("Invalid Character In Aadhaar, Only Number Allowed");
		    document.getElementById("ssno").focus();
		   return false;
		}
			for(var loop=0; loop<ssno.length; loop++)
			{
			  var ch= ssno.charAt(loop);
			   if(ch>='0' && ch<='9')
			   {}	
			   else{
				alert("Invalid Character In AADHAAR, Only Numbers Allowed");
				document.getElementById("ssno").focus();
				return false;
				}
			}
				
	

		//validation for pan no.

		var panno = document.getElementById("panno").value;
	  if(panno.length != 10)
             {
		alert("Invalid Character in PAN no., PAN No. Length Is not 10");
		document.getElementById("panno").focus();
		return false;
		}
		
			for(var loop=0; loop<panno.length; loop++)
			{
			  var ch= panno.charAt(loop);
			   if((ch>='0' && ch<='9') || (ch>='A' && ch<='Z'))
			   {}	
			   else{
				alert("Invalid Character In PAN no., Only Numbers and Alphabets Allowed");
				document.getElementById("panno").focus();
				return false;
				}
			}
			
	
          ////////////////validation for DOB////////////////

		var dob = document.getElementById("dob").value;
		if(dob.length<8)
		{
			alert("Valid DOB Required");
			document.getElementById("dob").focus();
			return false;
		}

		var dob_array = new Array();
		dob_array = dob.split("-");
		if(Number(dob_array[0])<1945)
		{
		  alert('Invalid Dob, Greater year Required');
		  document.getElementById("dob").focus();
		  return false;
		}

		
            // validation for qualifictions
		
		var is_qualification_selected=0;
		var intermediate = document.getElementById("intermediate").checked;
		if(intermediate == true)
		is_qualification_selected=1;

		var graduation = document.getElementById("graduation").checked;
		if(graduation == true)
		is_qualification_selected=1;

		var postgraduation = document.getElementById("postgraduation").checked;
		if(postgraduation == true)
		is_qualification_selected=1;
		
		if(is_qualification_selected==0)
		{	
		 alert("Qualification Is Manadatory");
		 return false;
		}



	var res = confirm("Are you sure you want to continue");
	if(res == false)
	return false;

	}
	catch(e){
	alert(e);
	console.log(e);
	return false;
	}
    }
	</script>
</html>
</body>