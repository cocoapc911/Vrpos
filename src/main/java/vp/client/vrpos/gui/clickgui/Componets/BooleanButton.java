package vp.client.vrpos.gui.clickgui.Componets;

import org.lwjgl.input.Keyboard;
import vp.client.vrpos.gui.clickgui.Component;
import vp.client.vrpos.module.Setting;
import vp.client.vrpos.util.ColorUtil;
import vp.client.vrpos.util.MouseUtil;
import vp.client.vrpos.util.RenderUtil;

import java.awt.*;

public class BooleanButton extends Component {
    public Setting<Boolean> setting;

    public BooleanButton(Setting setting){
        this.setting = setting;
        this.width = 100;
        this.height = 17;
    }

    @Override
    public Float drawScreen(int mouseX, int mouseY, float x , float y) {
        boolean visible = setting.isVisible();
        if(visible){
            this.x = x;
            this.y = y;
            RenderUtil.drawRect(x , y , width , height , ColorUtil.toRGBA(new Color(70,90,100 , 210)));
            if(setting.getValue())
                RenderUtil.drawRect(x + 1 , y + 1, width + (-1 * 2) , height + (-1 * 2) , enable);
            if(isMouseHovering(mouseX , mouseY))
                RenderUtil.drawRect(x + 1 , y + 1, width + (-1 * 2) , height + (-1 * 2) , hovering);

            float nameY = RenderUtil.getCenter(y , height , RenderUtil.getStringHeight());
            RenderUtil.drawString(setting.name
                    , x + 5, nameY,  ColorUtil.toRGBA(new Color(255 , 255 , 255)) , true);

            return height;
        }
        return 0.0F;
    }

    @Override
    public void onMouseClicked(int mouseX , int mouseY , int mouseButton){
        if(isMouseHovering(mouseX , mouseY) && mouseButton == MouseUtil.MOUSE_LEFT) setting.setValue(!setting.getValue());
    }
}
