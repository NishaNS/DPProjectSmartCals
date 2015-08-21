package edu.scu.dp.smartcals.model;

/**
 * @author Nisha Narayanaswamy
 * 
 * NutritionalInfo Model
 *
 */
public class NutritionalInfoModel {
	
	//Builder design Pattern to be applied
	//only getter methods added so far ****** setter methods required for Admin
	
	private final long productID;		
	private final String servingSize;
	private final String calories;
	private final String totalFat;
	private final String saturatedFat;
	private final String transFat;
	private final String cholestrol;
	private final String sodium;
	private final String totalCarbs;
	private final String dietaryFiber;
	private final String sugars;
	private final String protein;
	private final String iron;
	private final String smartTag;
	
	public static class NutriBuilder{
		
		//Required parameters
		private final long productID;
		private final String calories;
		private final String smartTag;
		
		//optional parameters	
		private String servingSize = "0";
		private String totalFat = "0";
		private String saturatedFat = "0";
		private String transFat = "0";
		private String cholestrol = "0";
		private String sodium = "0";
		private String totalCarbs = "0";
		private String dietaryFiber = "0";
		private String sugars = "0";
		private String protein = "0";
		private String iron = "0";
		
		public  NutriBuilder(long productID, String calories, String smartTag){
			this.productID = productID;
			this.calories = calories;
			this.smartTag = smartTag;			
		}

		public NutriBuilder servingSize(String value) {
			this.servingSize = value;
			return this;			
		}
		
		public NutriBuilder totalFat(String value) {
			this.totalFat = value;
			return this;			
		}
		
		public NutriBuilder saturatedFat(String value) {
			this.saturatedFat = value;
			return this;			
		}
		public NutriBuilder transFat(String value) {
			this.transFat = value;
			return this;			
		}
		public NutriBuilder cholestrol(String value) {
			this.cholestrol = value;
			return this;			
		}
		public NutriBuilder sodium(String value) {
			this.sodium = value;
			return this;			
		}
		public NutriBuilder totalCarbs(String value) {
			this.totalCarbs = value;
			return this;			
		}
		public NutriBuilder dietaryFiber(String value) {
			this.dietaryFiber = value;
			return this;			
		}
		public NutriBuilder sugars(String value) {
			this.sugars = value;
			return this;			
		}
		public NutriBuilder protein(String value) {
			this.protein = value;
			return this;			
		}
		public NutriBuilder iron(String value) {
			this.iron = value;
			return this;			
		}
	
		/**
		 * @return A builder object
		 */
		public NutritionalInfoModel buildNutriInfo(){
			return new NutritionalInfoModel(this);			
		}
		
	}
	
	private NutritionalInfoModel(NutriBuilder nutriBuilder) {
		
		productID = nutriBuilder.productID;		
		servingSize = nutriBuilder.servingSize;
		calories  = nutriBuilder.calories;
		totalFat  = nutriBuilder.totalFat;
		saturatedFat = nutriBuilder.saturatedFat;
		transFat = nutriBuilder.transFat;
		cholestrol = nutriBuilder.cholestrol;
		sodium = nutriBuilder.sodium;
		totalCarbs = nutriBuilder.totalCarbs;
		dietaryFiber = nutriBuilder.dietaryFiber;
		sugars = nutriBuilder.sugars;
		protein = nutriBuilder.protein;
		iron = nutriBuilder.iron;
		smartTag = nutriBuilder.smartTag;
		
	}
	
	@Override
	public String toString(){
		
		//later on remove productID from display. 
		//there is no need to display Smart Tag
		
		return "<html>\nProductID: " + productID 		
		+ "\n<br> Serving Size: " + servingSize
		+ "\n, Calories: " + calories
		+ "\n, Total Fat: " + totalFat
		+ "\n, Saturated Fat: " + saturatedFat
		+ "\n<br> Trans Fat: " + transFat
		+ "\n, Cholestrol: " + cholestrol
		+ "\n, Sodium: " + sodium
		+ "\n, Total Carbs: " + totalCarbs
		+ "\n, Dietary Fiber: " +  dietaryFiber
		+ "\n<br> Sugars: " +  sugars
		+ "\n, Protein: " + protein
		+ "\n, Iron: </html>" + iron;
	}
}
