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
		private String servingSize = null;
		private String totalFat = null;
		private String saturatedFat = null;
		private String transFat = null;
		private String cholestrol = null;
		private String sodium = null;
		private String totalCarbs = null;
		private String dietaryFiber = null;
		private String sugars = null;
		private String protein = null;
		private String iron = null;
		
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
		
		return "ProductID: " + productID 		
		+ "\nServing Size: " + servingSize
		+ "\nCalories: " + calories
		+ "\nTotal Fat: " + totalFat
		+ "\nSaturated Fat: " + saturatedFat
		+ "\nTrans Fat: " + transFat
		+ "\nCholestrol: " + cholestrol
		+ "\nSodium: " + sodium
		+ "\nTotal Carbs: " + totalCarbs
		+ "\nDietary Fiber: " +  dietaryFiber
		+ "\nSugars: " +  sugars
		+ "\nProtein: " + protein
		+ "\nIron: " + iron;
	}
}
