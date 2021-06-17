const Registration = require('../models/hall.model')

const getAllregistration = async (req,res)=>{

    const allRegistration = await Registration.find();

    if (!allRegistration)
    {
     res.status(400).json({
         hasError : true
     })    
    }

    res.status(200).json({
        hasError : false,
        halls : allHalls
    })

}

const getSpecificRegistration = async (req,res)=>{

    const id = req.params.id

    const Registration = await Registration.findOne({_id : id});

    if(!Registration)
    {
        res.status(405).json({
            hasError : true,
            message : "Registration not found" 
        })
    }

    res.status(200).json({
        hasError :false,
        Registration
    })

}

const addARegistration = async(req,res)=>{

    const Registration = req.body


    const result = await Registration.create(hall)

    if(!result){
        res.status(400)
    }
    

    res.status(200).json({
        hasError : false,
        message : "Registration has been updated"
    })
}

const updateARegistration = async (req,res)=>{
    const Registration = req.body
    const id = req.params.id

    const result = await Registration.updateOne({_id : id} , Registration , {new : true})

    if(!result)
    {
     return   res.status(400).json({
            hasError : true,
            message : "failed to update"
        })
    }


    res.status(200).json({
        hasError : false,
        message : "Registration has been updated successfully"
    })
}

const deleteAhall = async(req,res)=>{
    const id = req.params.id

    const result = await Registration.deleteOne({_id , id})

    if(!result){
      res.status(400).json({
        hasError : true,
        message : "failed tp delete the Registration"
      })
    }

    res.status(200).json({
        hasError : false ,
        mesage :"Registration deleted successsfully"
    })
}

module.exports = {
    getSpecificRegistration,
    getAllRegistration,
    deleteARegistration,
    updateARegistration,
    addARegistration
}