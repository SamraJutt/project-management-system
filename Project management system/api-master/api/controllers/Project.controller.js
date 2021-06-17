const Project = require('../models/participent.model')



const getAllProject = async (req,res)=>{

    const allProject = await Project.find();

    if (!allProjects)
    {
     res.status(400).json({
         hasError : true
     })    
    }

    res.status(200).json({
        hasError : false,
        Projects : allProjects
    })

}

const getSpecificparticipent = async (req,res)=>{

    const id = req.params.id

    const participent = await Participent.findOne({_id : id});

    if(!participent)
    {
        res.status(405).json({
            hasError : true,
            message : "participent not found" 
        })
    }

    res.status(200).json({
        hasError :false,
        participent
    })

}

const addParticipent = async(req,res)=>{
    console.log("participent")
    const participent = req.body
    

    const result = await Participent.create(participent)

    if(!result){
        res.status(400)
    }
    

    res.status(200).json({
        hasError : false,
        message : "participent has been Added"
    })
}

const updateParticipent = async (req,res)=>{
    const participent = req.body
    const id = req.params.id

    const result = await Participent.updateOne({_id : id} , participent , {new : true})

    if(!result)
    {
     return   res.status(400).json({
            hasError : true,
            message : "failed to update"
        })
    }


    res.status(200).json({
        hasError : false,
        message : "participent has been updated successfully"
    })
}

const deleteParticipent = async(req,res)=>{
    const id = req.params.id

    const result = await Participent.deleteOne({_id : id})

    if(!result){
      res.status(400).json({
        hasError : true,
        message : "failed tp delete the participent"
      })
    }

    res.status(200).json({
        hasError : false ,
        mesage :"participent deleted successsfully"
    })
}

module.exports = {
    getSpecificparticipent,
    getAllparticipents,
    deleteParticipent,
    updateParticipent,
    addParticipent
}