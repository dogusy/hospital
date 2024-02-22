# hospital

@Post   
/hospital/register:    
creates hospital. @Params -> hospital name, address, type  

@Get   
/hospital/hospitalNames   
gets registered hospital names   
     
@Get("/hospital/{hospitalId}")    
gets hospital's patient appointment list    
    
@Get    
/hospital    
gets hospital types (Diş Hastanesi, Göz Hastanesi, Genel Hastane ve Diğer)   
   
@Put    
/hospital    
@Params -> hospital name, address, type   
updates and returns hospital information   

# patient
  
@Post   
patient/appointmentListByHospitalId   
@Params hospital id(id)   
takes hospital id as parameter and return appointment list which is related to hospital   

@Post     
patient/appointmentListByTC   
@Params tc
takes tc as parameter and return appointment list which is related to hospital    


@Post      
patient/makeAppointment       
@Params username, surname, sex, age, address, hospitalName, complaint, tc      
create and returns appointments       
 
@Delete       
@Params appointment id      
/patients     
deletes selected appointment     

@PostMapping      
patients/updatePatientDetails      
@Params TC,username,surname,sex,age,address,     
takes parameters, create a new appointment and save relations      









