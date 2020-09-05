package jp.co.cybermissions.itspj.android.listviewsample2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class OrderConfirmDialogFragment:DialogFragment() {
    override fun onCreateDialog(savedInstanceState:Bundle?): Dialog {
        //ダイアログビルダを生成
        val builder = AlertDialog.Builder(activity)
        //ダイアログのタイトルを設定
        builder.setTitle(R.string.dialog_title)
        //ダイアログのメッセージを設定
        builder.setMessage(R.string.dialog_msg)
        //PositiveButtonを設定
        builder.setPositiveButton(R.string.dialog_btn_ok, DialogButtonClickListener())
        //NegativeButtonを設定
        builder.setNegativeButton(R.string.dialog_btn_ng, DialogButtonClickListener())
        //NeutralButtonを設定
        builder.setNeutralButton(R.string.dialog_btn_nu, DialogButtonClickListener())
        //ダイアログオブジェクトを生成し、リターン
        val dialog = builder.create()
        return dialog
    }

    //ダイアログのアクションボタンがタップされた時の処理が記述されたメンバクラス
    private inner class DialogButtonClickListener:DialogInterface.OnClickListener {
        override fun onClick(dialog:DialogInterface, which:Int) {
            //トーストメッセージ用文字列変数を用意
            var msg = ""
            //タップされたアクションボタンで分岐
            when(which){
                //Positive Button
                DialogInterface.BUTTON_POSITIVE ->
                    msg = getString(R.string.dialog_ok_toast)
                //Negative Button
                DialogInterface.BUTTON_NEGATIVE ->
                    msg = getString(R.string.dialog_ng_toast)
                //Neautral Button
                DialogInterface.BUTTON_NEUTRAL ->
                    msg = getString(R.string.dialog_nu_toast)
            }
            //トーストの表示
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        }
    }
}