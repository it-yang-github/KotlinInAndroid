package com.example.animation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import com.example.a40248.kotlininandroid.utils.showToas
import kotlinx.android.synthetic.main.activity_main.*

import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

/**
 * 这；练习的 渐变动画
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initlisener()
    }
    fun initlisener(): Unit {
        move.onClick {
            //(int fromXType, float fromXValue, int toXType, float toXValue,
            // int fromYType, float fromYValue, int toYType, float toYValue)
            var ta = TranslateAnimation(AlphaAnimation.RELATIVE_TO_SELF, 0f, AlphaAnimation.RELATIVE_TO_SELF, 0f,
                    AlphaAnimation.RELATIVE_TO_SELF, 0f, AlphaAnimation.RELATIVE_TO_SELF,5f)
            ta.duration = 1000
            ta.fillAfter=true
            showToas("move")
            move.startAnimation(ta)
        }
        alpa.onClick {
            var arpAnimation = AlphaAnimation(0f, 1f)
            arpAnimation.duration = 5000
            showToas("alpa")
            alpa.startAnimation(arpAnimation)
        }
        scle.onClick {
            /**
             * ScaleAnimation(float fromX, float toX, float fromY, float toY,
            int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
            //第一个参数fromX为动画起始时 X坐标上的伸缩尺寸
            //第二个参数toX为动画结束时 X坐标上的伸缩尺寸
            //第三个参数fromY为动画起始时Y坐标上的伸缩尺寸
            //第四个参数toY为动画结束时Y坐标上的伸缩尺寸
            /*说明:
            以上四种属性值
            0.0表示收缩到没有
            1.0表示正常无伸缩
            值小于1.0表示收缩
            值大于1.0表示放大
            */
            //第五个参数pivotXType为动画在X轴相对于物件位置类型
            //第六个参数pivotXValue为动画相对于物件的X坐标的开始位置
            //第七个参数pivotXType为动画在Y轴相对于物件位置类型
            //第八个参数pivotYValue为动画相对于物件的Y坐标的开始位置
             */
            var scleanimat = ScaleAnimation(1f, 0.5f, 1f, 4f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f)

            scleanimat.duration = 3000
            scle.startAnimation(scleanimat)
            showToas("scle")

        }
        rotate.onClick {
            /**
             *
            RotateAnimation(float fromDegrees, float toDegrees,
            int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
            //第一个参数fromDegrees为动画起始时的旋转角度
            //第二个参数toDegrees为动画旋转到的角度
            //第三个参数pivotXType为动画在X轴相对于物件位置类型
            //第四个参数pivotXValue为动画相对于物件的X坐标的开始位置
            //第五个参数pivotXType为动画在Y轴相对于物件位置类型
            //第六个参数pivotYValue为动画相对于物件的Y坐标的开始位置
            myAnimation_Rotate=new RotateAnimation(0.0f, +350.0f,
            Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
             */
            var rotateanimation= RotateAnimation(0f,180f,RotateAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f)
            rotateanimation.duration=3000
            showToas("rotate")
            rotate.startAnimation(rotateanimation)
        }
        set.onClick {
            var arpAnimation = AlphaAnimation(0.2f, 1f)
            var rotateanimation= RotateAnimation(0f,180f,RotateAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f)
            var scleanimat = ScaleAnimation(1f, 0.5f, 1f, 4f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f)
            var ta = TranslateAnimation(AlphaAnimation.RELATIVE_TO_SELF, 0f, AlphaAnimation.RELATIVE_TO_SELF, 5f, AlphaAnimation.RELATIVE_TO_SELF, 0f, AlphaAnimation.RELATIVE_TO_SELF, 10f)
            var setan= AnimationSet(true)
            setan.addAnimation(ta)
            setan.addAnimation(scleanimat)
            setan.addAnimation(rotateanimation)
            setan.addAnimation(arpAnimation)
            setan.duration=500
            showToas("set")
            set.startAnimation(setan)
        }
        goToOther.onClick {
            startActivity<Other_activity>()
        }
    }
}
