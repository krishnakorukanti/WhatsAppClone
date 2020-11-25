package com.example.whatsapp.fragments

import android.app.Activity.RESULT_OK
import android.app.ProgressDialog
import android.app.TaskInfo
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp.R
import com.example.whatsapp.adapter.StatusAdapter
import com.example.whatsapp.data.Status_1
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StreamDownloadTask
import com.google.firebase.storage.UploadTask
import com.google.firebase.storage.UploadTask.TaskSnapshot
import kotlinx.android.synthetic.main.fragment_calls.recycler_view
import kotlinx.android.synthetic.main.fragment_status.*
import java.util.*


class StatusFragment : Fragment() {
    private val modelList = ArrayList<Status_1>()
    private lateinit var imageUri: Uri
    private lateinit var storage:FirebaseStorage
    private lateinit var storageReference:StorageReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view:View=  inflater.inflate(R.layout.fragment_status, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buildModelList()
        val itemAdapter = StatusAdapter(modelList)
        recycler_view. layoutManager = LinearLayoutManager(this.context)
        recycler_view.adapter = itemAdapter
        storage = FirebaseStorage.getInstance()
        storageReference = storage.getReference()
        contact_img_triple.setOnClickListener(View.OnClickListener {
            choosePicture()
        })
    }

    private fun choosePicture() {
        val intent = Intent()
        intent.setType("image/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null ){
            imageUri = data.getData()!!
            contact_img_triple.setImageURI(imageUri)
            uploadPicture()
        }
    }

    private fun uploadPicture() {
        val pd = ProgressDialog(this.context)
        pd.setTitle("Uploading the status")
        pd.show()

          val randomKey:String = UUID.randomUUID().toString()

        val riversRef: StorageReference = storageReference.child("images/" + randomKey)

        riversRef.putFile(imageUri)
            .addOnSuccessListener { taskSnapshot -> // Get a URL to the uploaded content
              //  val downloadUrl: Uri = taskSnapshot.uploadSessionUri!!
                pd.dismiss()
                Toast.makeText(this.context,"Image is Uploaded",Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                // Handle unsuccessful uploads
                // ...
                pd.dismiss()
                Toast.makeText(this.context,"Failed",Toast.LENGTH_SHORT).show()
            }
            .addOnProgressListener {
              var  progressPercent:Double = (100.00 )
                pd.setMessage("progress"+progressPercent)
            }
    }

    private fun buildModelList() {
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))
        modelList.add(Status_1(R.drawable.john_1, "John"))

    }

}

