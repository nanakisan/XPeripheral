package dirich.ly.bit.xperipheral.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import dirich.ly.bit.xperipheral.librarys.bases.TechneModelBase;

public class BasicTileEntityModel extends TechneModelBase{
	//fields
	ModelRenderer Shape1;
	
	public BasicTileEntityModel()
	{
		textureWidth = 64;
		textureHeight = 32;
		
			Shape1 = new ModelRenderer(this, 0, 0);
			Shape1.addBox(-8F, 8F, -8F, 16, 16, 16);
			Shape1.setRotationPoint(0F, 0F, 0F);
			Shape1.setTextureSize(64, 32);
			Shape1.mirror = true;
			setRotation(Shape1, 0F, 0F, 0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
	}
	
	@Override
	public void renderModel(float f){
		Shape1.render(f);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}

}
