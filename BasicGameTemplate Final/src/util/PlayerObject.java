package util;


public class PlayerObject {
	
	private Point3f centre= new Point3f(0,0,0);			// Centre of object, using 3D as objects may be scaled  
	private int width=10;
	private int height=10;
	private boolean hasTextured=false;
	private String textureLocation; 
	private String blanktexture="res/blankSprite.png";
	private boolean isGrounded;
	float  velocityY; 
	float gravity=(float) -.5;
	public PlayerObject() {  
		
	}
	
    public PlayerObject(String textureLocation,int width,int height,Point3f centre) { 
    	 hasTextured=true;
    	 this.textureLocation=textureLocation;
    	 this.width=width;
		 this.height=height;
		 this.centre =centre;
	}
    public void jumpLogic() {
    	if(centre.getY()>800&&velocityY>0) {			
			velocityY=0;
		}    
		if(centre.getY()<800) {
				velocityY-=gravity;			
		}
		if(velocityY<0) {
			velocityY-=gravity;	
		}
    	centre.setY(centre.getY()+velocityY);    }
    public void update() {
    	jumpLogic();
		
    }
    public float getVelocity() {
    	return velocityY;
    }
    public boolean isGrounded() {
    	return isGrounded;
    }
    public void setYVelocity(float velocity) {
    	velocityY=velocity;
    }

	public Point3f getCentre() {
		return centre;
	}

	public void setCentre(Point3f centre) {
		this.centre = centre;
		
		//make sure to put boundaries on the gameObject 
	 
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getTexture() {
		if(hasTextured) 
			{
			return textureLocation;
			}
		 
		return blanktexture; 
	}
  
}
