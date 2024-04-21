package kw.kng.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import kw.kng.entity.MarriageSeeker;
import kw.kng.service.MarriageSeekerService;

@Component
public class LobTestRunner implements CommandLineRunner
{

	@Autowired
	MarriageSeekerService ms;
	
	@Override
	public void run(String... args) throws Exception 
	{
		
		//------------------------------------------------------------------------------------------------------------------------------------------------
		
									//LOB:
		
		
		//Comment here:
		//--------------------
		
		/*
		
		System.out.println("REGISTER PERSON BIO DATA:");
		System.out.println("------------------------------------------");
		Scanner sc = new Scanner(System.in);

		// Use trim() to remove any leading or trailing whitespace.
		System.out.println("Enter person name: ");
		String name = sc.nextLine().trim();

		// Added trim() for address input.
		System.out.println("Enter person address: ");
		String addrs = sc.nextLine().trim();

		// Use a loop to ensure valid file paths are provided for the photo.
		String photoPath = "";
		while (photoPath.isEmpty()) 
		{
		    System.out.println("Enter Person photo file complete path: ");
		    photoPath = sc.nextLine().trim().replace("?", "");
		    if (!new File(photoPath).exists()) {
		        System.out.println("Person photo File for the specified file path does not exist, please try again.");
		        photoPath = ""; // Reset if the path is invalid
		    }
		}

		// Use a loop to ensure valid file paths are provided for the biodata.
		String biodataPath = "";
		while (biodataPath.isEmpty()) {
		    System.out.println("Enter Person biodata file complete path: ");
		    biodataPath = sc.nextLine().trim().replace("?", "");
		    if (!new File(biodataPath).exists()) {
		        System.out.println("Person Biodata File for the specified file path does not exist, please try again.");
		        biodataPath = ""; // Reset if the path is invalid
		    }
		}

		// Ask about nationality.
		System.out.println("Is the person Indian? (true/false): ");
		boolean indian = sc.nextBoolean();

		byte[] photoData;
		char[] bioDataContent;
		
		//EXCEPTION HANDLING here:
		try {
		    // Handling IOException.
		    // Prepare byte[] representing photo file content.
		    InputStream is = new FileInputStream(photoPath);
		    photoData = new byte[is.available()];
		    is.read(photoData);
		    is.close(); // Close the InputStream after use.

		    // Prepare char[] representing biodata file content.
		    File file = new File(biodataPath);
		    Reader reader = new FileReader(file);
		    bioDataContent = new char[(int) file.length()];
		    reader.read(bioDataContent);
		    reader.close(); // Close the Reader after use.

		    // Added try-catch block to handle DateTimeParseException for date of birth.
		    LocalDateTime dob = LocalDateTime.of(1990, 11, 23, 12, 45);

		    // Prepare Entity class obj.
		    MarriageSeeker seeker = new MarriageSeeker(name, addrs, photoData, dob, bioDataContent, indian);

		    // Handling the service layer exception.
		    try 
		    {
		        System.out.println(ms.registerMarriageSeeker(seeker));
		    }
		    catch (Exception e) 
		    {
		        System.out.println("Failed to register marriage seeker: " + e.getMessage());
		    }

		} 
		catch (IOException e) 
		{
		    System.out.println("Error reading files: " + e.getMessage());
		}
		
		
		*/
		
		//------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		System.out.println("Enter the ID of the person to retrieve: ");
		Scanner sc = new Scanner(System.in);
		Long id = sc.nextLong();
		sc.nextLine();
		
		Optional<MarriageSeeker> seekerOptional = ms.searchSeekerById(id);

		if(seekerOptional.isPresent()) 
		{
		    MarriageSeeker seeker = seekerOptional.get();
		    // Display the data or process it as required
		    System.out.println("ID Value: " + id + ":");
		    System.out.println("Name: " + seeker.getName());
		    System.out.println("Address: " + seeker.getAddrs());
		   
		    System.out.println("Photo: ");
		    try (OutputStream os = new FileOutputStream(seeker.getName() + ".png")) 
		    {
		        os.write(seeker.getPhoto());
		        System.out.println("Photo has been written to file: "+seeker.getName()+".png");
		    }
		    
		    System.out.println("Biodata: ");
		    try (Writer w = new FileWriter(seeker.getName() + ".txt")) 
		    {
		    	char[] bioDataContenet= seeker.getBiodata();
		        w.write(bioDataContenet);
		        System.out.println("Bio data has been written to file "+seeker.getName()+ ".txt");
		    }
		    catch(IOException e)
		    {
		    	System.out.println(" An error occured while writing the bio data to file:" + e.getMessage() );
		    	
		    }
		    
		}
		else 
		{
		    System.out.println("No record found with ID: " + id);
		}
		
		
		//------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		
	}

}

/*
 
 To view the `blob` data from db. Do the following:
 
 1. select the required blob data you want.
 2. Right click -> Save value to file.
 3. enter the name of the file you want and the format. e.g `ed.png`
 	3.1 Save as type : `All File(*)`
 4. Go to the specified folder where your files are saved. In my case `D:`
 
 
 */

